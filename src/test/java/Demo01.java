import service.SearchService;

import java.io.File;
import java.util.Date;
import java.util.List;

public class Demo01 {

    public static void main(String[] args) throws Exception{
        File root = new File("D:/workplace\\idea_projects");
        File root2 = new File("D:\\workplace\\idea_projects\\ToolWarehouseSystem");
        Date date = new Date(root.lastModified());
        Date date2 = new Date(root2.lastModified());

        List<File> files =  SearchService.searchFileByModifiedTime(root, date2);
        for(File file : files){
            System.out.println(file.getAbsolutePath());
        }
    }
}
