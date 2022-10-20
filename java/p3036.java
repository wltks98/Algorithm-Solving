// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p3036.java

import java.io.PrintStream;
import java.util.Scanner;

public class p3036
{

    public p3036()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for(int i = 1; i < n; i++)
        {
            int k = gcd(a[0], a[i]);
            System.out.println((new StringBuilder(String.valueOf(a[0] / k))).append("/").append(a[i] / k).toString());
        }

    }

    static int gcd(int a, int b)
    {
        int r;
        for(; b != 0; b = r)
        {
            r = a % b;
            a = b;
        }

        return a;
    }
}
