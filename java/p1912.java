// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1912.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1912
{

    public p1912()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        int b[] = new int[n + 1];
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        b[1] = a[1];
        int max = 0x80000000;
        if(max < b[1])
            max = b[1];
        for(int i = 2; i <= n; i++)
        {
            b[i] = Math.max(b[i - 1] + a[i], a[i]);
            if(max < b[i])
                max = b[i];
        }

        System.out.println(max);
    }
}
