// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2108.java

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class p2108
{

    public p2108()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int col[] = new int[8001];
        int p[] = new int[n];
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for(int i = 0; i < n; i++)
        {
            p[i] = sc.nextInt();
            a += p[i];
            col[p[i] + 4000]++;
        }

        Arrays.sort(p);
        Arrays.sort(col);
        System.out.println(Math.round((double)a / (double)n));
        System.out.println(p[n / 2]);
        System.out.println(col[8000]);
        System.out.println(p[n - 1] - p[0]);
    }
}
