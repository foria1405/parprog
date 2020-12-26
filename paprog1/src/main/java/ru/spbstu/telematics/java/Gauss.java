package ru.spbstu.telematics.java;

import java.io.FileReader;
import java.util.Scanner;

public class Gauss {
    private int N;
    private int M;
    private double [][] matrA;
    private double [] matrB;
    private double [] res;


    public Gauss(String str){
        try {
            FileReader file=new FileReader(str);
            Scanner s = new Scanner(file);
            N = s.nextInt();
            M = s.nextInt();
            matrA = new double[N][M];
            matrB = new double[N];
            res = new double[N];
            for (int i = 0; i < M; i++) {
                matrA[i] = new double[M];
                for (int j = 0; j < M; j++) {
                    matrA[i][j] = s.nextDouble();
                }
                matrB[i] = s.nextDouble();
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public int getN() {
        return N;
    }

    public void solver() throws MyException {
        for (int p = 0; p < N; p++) {

            int max = p;
            for (int i = p + 1; i < N; i++) {
                if (Math.abs(matrA[i][p]) > Math.abs(matrA[max][p])) {
                    max = i;
                }
            }
            double[] temp = matrA[p];
            matrA[p] = matrA[max];
            matrA[max] = temp;

            double   t    = matrB[p];
            matrB[p] = matrB[max];
            matrB[max] = t;

            if (Math.abs(matrA[p][p]) <= 1e-10) {
                throw new MyException("NO");
            }

            for (int i = p + 1; i < N; i++) {
                double alpha = matrA[i][p] / matrA[p][p];
                matrB[i] -= alpha * matrB[p];
                for (int j = p; j < N; j++) {
                    matrA[i][j] -= alpha * matrA[p][j];
                }
            }
        }
    }

    public void back(){
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += matrA[i][j] * res[j];
            }
            res[i] = (matrB[i] - sum) / matrA[i][i];
        }
    }

    public double[] getRes() throws MyException {
        if (N < M) {
            throw new MyException("INF");
        }else return res;
    }




}
