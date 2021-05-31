package service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchService {

    public static List<File> searchFileByName(String directory, String suffix)throws FileNotExistException{
        File root = new File(directory);
        return searchFileByName(root, suffix);

    }

    public static List<File> searchFileByName(File root, String suffix)throws FileNotExistException{
        if(!root.exists()){throw new FileNotExistException();}

        List<File> results = new ArrayList<>();

        if (root.isDirectory()) {
            File[] childs = root.listFiles();
            for(File file : childs){
                if(file.isDirectory()){
                    results.addAll(searchFileByName(file, suffix));
                }
                else if(file.getName().endsWith(suffix)){
                    results.add(file);
                }
            }
        }
        else{
            if(root.getName().endsWith(suffix)){
                results.add(root);
            }
        }

        return results;

    }

    public static List<File> searchFileByModifiedTime(String directory, Date time) throws FileNotExistException{
        File root = new File(directory);
        return searchFileByModifiedTime(root, time);
    }

    public static List<File> searchFileByModifiedTime(File root, Date time)throws FileNotExistException{
        if(!root.exists()){throw new FileNotExistException();}
        List<File> results = new ArrayList<>();

        if (root.isDirectory()) {
            File[] childs = root.listFiles();
            for(File file : childs){
                if(file.isDirectory()){
                    results.addAll(searchFileByModifiedTime(file, time));
                }
                else if((new Date(file.lastModified())).after(time)){
                    results.add(file);
                }
            }
        }
        else{
            if((new Date(root.lastModified())).after(time)){
                results.add(root);
            }
        }

        return results;
    }
}
