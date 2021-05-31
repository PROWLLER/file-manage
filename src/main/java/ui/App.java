package ui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("文件检索程序");
        try{
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/sample.fxml"));

            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
        stage.setResizable(false);
    }



}
