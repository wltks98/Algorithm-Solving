// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2740.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2740
{

    public p2740()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

        }

        int x = sc.nextInt();
        int y = sc.nextInt();
        int b[][] = new int[y][x];
        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < y; j++)
                b[j][i] = sc.nextInt();

        }

        int c[][] = new int[n][y];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < y; j++)
            {
                c[i][j] = matrix(a[i], b[j]);
                System.out.print((new StringBuilder(String.valueOf(c[i][j]))).append(" ").toString());
            }

            System.out.print("\n");
        }

    }

    public static int matrix(int a[], int b[])
    {
        int r = 0;
        for(int i = 0; i < a.length; i++)
            r += a[i] * b[i];

        return r;
    }
}
