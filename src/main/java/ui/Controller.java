package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import service.SearchService;

import java.io.File;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button searchBySuffixButton;

    @FXML
    private Button searchByDateButton;

    @FXML
    private TextField suffixText;

    @FXML
    private DatePicker dateText;

    @FXML
    private TextField rootText;

    @FXML
    private ListView<String> showText;

    @FXML
    private TextArea consoleText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        consoleText.setEditable(false);
        showText.setEditable(false);
        searchBySuffixButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                String suffix = suffixText.getText();
                if(!suffix.startsWith(".")){

                     suffix = "." + suffix;
                }

                String directory = rootText.getText();
                List<File> files = null;
                try{
                     files = SearchService.searchFileByName(directory, suffix);
                }catch (Exception e){
                     consoleText.setText("你的目录是不是写错了？");
                     showText.getItems().clear();
                     e.printStackTrace();
                     return;
                }

                consoleText.setText("成功导出目录");
                ArrayList<String> names = new ArrayList<>();

                for(File file : files){
                     names.add(file.getAbsolutePath());
                }
                ObservableList<String> fileNames = FXCollections.observableArrayList(names);
                showText.setItems(fileNames);
             }
        }

        );

        searchByDateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LocalDate localDate = dateText.getValue();
                String directory = rootText.getText();
                ZoneId zone = ZoneId.systemDefault();
                Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
                Date date = Date.from(instant);
                List<File> files = null;
                try{
                    files = SearchService.searchFileByModifiedTime(directory, date);
                }catch (Exception e){
                    consoleText.setText("你的目录是不是写错了？");
                    showText.getItems().clear();
                    e.printStackTrace();
                    return;
                }

                consoleText.setText("成功导出目录");
                ArrayList<String> names = new ArrayList<>();

                for(File file : files){
                    names.add(file.getAbsolutePath());
                }
                ObservableList<String> fileNames = FXCollections.observableArrayList(names);
                showText.setItems(fileNames);

            }
        });
    }




}
