// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1037.java

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class p1037
{

    public p1037()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        Arrays.sort(a);
        System.out.println(a[0] * a[n - 1]);
    }
}
