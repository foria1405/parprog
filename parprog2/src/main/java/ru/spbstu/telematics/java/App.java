package ru.spbstu.telematics.java;

import java.util.Queue;
import java.util.Vector;


public class App 
{
    public static void main( String[] args )
    {
        MyQueue<Integer> myQueue = new MyQueue <Integer>();
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);

        Integer first = myQueue.remove();
        Integer second = myQueue.remove();
        boolean f = first==second;


    }
}
