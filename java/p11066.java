// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11066.java

import java.io.PrintStream;
import java.util.Scanner;

public class p11066
{

    public p11066()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int j = 0; j < n; j++)
            a[j] = sc.nextInt();

        fun(a, 0, n - 1);
        System.out.println(fun(a, 0, n - 1)[1]);
    }

    public static int[] fun(int a[], int m, int n)
    {
        int s = 0;
        int min[] = new int[2];
        min[0] = 0x7fffffff;
        min[1] = 0;
        for(int i = m; i < n; i++)
        {
            s = min[1];
            int x[] = sum(a, m, i);
            int y[] = sum(a, i + 1, n);
            s = x[1] + y[1];
            t = x[0] + y[0] + s;
            min[1] = t;
            if(min[0] > t)
                min[0] = t;
            t = 0;
            s = 0;
        }

        return min;
    }

    public static int[] sum(int a[], int m, int n)
    {
        if(n == m)
        {
            int b[] = new int[2];
            b[0] = a[m];
            b[1] += a[m];
            return b;
        } else
        {
            return fun(a, m, n);
        }
    }

    static int t = 0;

}
