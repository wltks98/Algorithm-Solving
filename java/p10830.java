// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10830.java

import java.util.Scanner;

public class p10830
{

    public p10830()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][] = new int[n][n];
        int a2[][] = new int[n][n];
        int b[][] = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                a2[j][i] = a[i][j] = sc.nextInt();

        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                b[i][j] = matrix(a[i], a2[j], m);

        }

    }

    public static int matrix(int a[], int b[], int m)
    {
        int r = 0;
        for(int i = 0; i < a.length; i++)
            r += a[i] * b[i];

        if(m == 1)
            return r;
        if(m % 2 == 0)
            return matrix(a, b, m / 2);
        else
            return matrix(a, b, m / 2) * r;
    }
}
