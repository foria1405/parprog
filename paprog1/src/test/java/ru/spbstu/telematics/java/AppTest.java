package ru.spbstu.telematics.java;

import junit.framework.TestCase;
import org.junit.*;
import java.io.*;


import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase
{
    static String [] files = {"text1.txt",  "text2.txt","text3.txt", "text4.txt", "text5.txt"};
    static String [] expected = {"1.0 2.0 1.0 ", "1.0 2.0 1.0 ",
            "INF", "NO", "INF" };
    private Gauss equations;
    static int countOfTest;

    @Test
    public void testApp()
    {
        for (int i= 0; i< files.length; i++){
            equations = new Gauss(files[i]);
            String actual = "";
            try{
                equations.solver();
                equations.back();
                double[] res =equations.getRes();
                for (int j = 0; j < res.length; j++) {
                    actual+=res[j] + " ";
                }
                System.out.println();
            }catch (MyException e){
                actual = e.getMessage();
                // System.out.println(e);
            }
            Assert.assertEquals("Ошибка в файле " + files[i], expected[i],actual);
        }
    }
}

