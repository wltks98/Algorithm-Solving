// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1463.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1463
{

    public p1463()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        int c[] = new int[n + 1];
        for(int i = 2; i <= n; i++)
        {
            int x;
            if(i % 2 == 0)
                x = Math.min(a[i - 1], a[i / 2]);
            else
                x = a[i - 1];
            int y;
            if(i % 3 == 0)
                y = Math.min(a[i / 3], x);
            else
                y = x;
            a[i] = y + 1;
        }

        System.out.println(a[n]);
    }
}
