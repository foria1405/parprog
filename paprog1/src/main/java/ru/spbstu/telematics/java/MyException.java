package ru.spbstu.telematics.java;

public class MyException extends Exception{
    String message;
    MyException(String str){
        message=str;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
