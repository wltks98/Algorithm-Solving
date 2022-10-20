// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1932.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1932
{

    public p1932()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        int save[][] = new int[n][500];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i; j++)
                save[i][j] = a[i][j] = sc.nextInt();

        }

        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                if(j - 1 >= 0 && save[i - 1][j - 1] > save[i - 1][j])
                    save[i][j] = a[i][j] + save[i - 1][j - 1];
                if(j - 1 < 0 || save[i - 1][j - 1] < save[i - 1][j])
                    save[i][j] = a[i][j] + save[i - 1][j];
            }

        }

        int max = 0;
        for(int i = 0; i < n; i++)
            if(max < save[n - 1][i])
                max = save[n - 1][i];

        System.out.println(max);
    }
}
