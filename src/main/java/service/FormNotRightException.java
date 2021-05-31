package service;

public class FormNotRightException extends Exception{

    public FormNotRightException(String msg){
        super(msg);
    }

    public FormNotRightException(){
        super();
    }
}
