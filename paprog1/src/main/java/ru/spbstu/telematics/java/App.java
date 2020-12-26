package ru.spbstu.telematics.java;
import java.io.FileReader;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App
{


    public static void main( String[] args )
    {
        Gauss equations = new Gauss("text5.txt");
        try {
            equations.solver();
            equations.back();
            double[] res;
            res = equations.getRes();
            for (int i = 0; i < equations.getN(); i++) {
                System.out.print(res[i] + " ");
            }
        }catch (MyException e){
            System.out.println(e);
        }
    }


}
