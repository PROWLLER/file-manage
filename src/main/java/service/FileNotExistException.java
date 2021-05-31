package service;

public class FileNotExistException extends Exception{
    public FileNotExistException(String msg){
        super(msg);
    }
    public FileNotExistException(){
        super();
    }
}
