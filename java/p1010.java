// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1010.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1010
{

    public p1010()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for(int p = 0; p < t; p++)
        {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int binomi[][] = new int[30][30];
            binomi[1][0] = binomi[1][1] = 1;
            for(int i = 2; i <= n; i++)
            {
                for(int j = 0; j <= i; j++)
                    if(i == j || j == 0)
                        binomi[i][j] = 1;
                    else
                        binomi[i][j] = binomi[i - 1][j - 1] + binomi[i - 1][j];

            }

            sb.append((new StringBuilder(String.valueOf(binomi[n][k]))).append("\n").toString());
        }

        System.out.println(sb);
    }

    static int factorial(int k)
    {
        if(k == 0)
            return 1;
        else
            return k * factorial(k - 1);
    }
}
