// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1003.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1003
{

    public p1003()
    {
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int array[] = new int[n];
        int fibo[][] = new int[500][2];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;
        for(int i = 0; i < n; i++)
            array[i] = input.nextInt();

        for(int i = 2; i < fibo.length; i++)
        {
            fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
            fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
        }

        for(int i = 0; i < n; i++)
            System.out.println((new StringBuilder(String.valueOf(fibo[array[i]][0]))).append(" ").append(fibo[array[i]][1]).toString());

        input.close();
    }
}
