// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2750.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2750
{

    public p2750()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        for(int i = 1; i < n; i++)
        {
            for(int j = i; j - 1 >= 0; j--)
            {
                if(a[j] >= a[j - 1])
                    break;
                x = a[j - 1];
                y = a[j];
                a[j - 1] = y;
                a[j] = x;
            }

        }

        for(int i = 0; i < n; i++)
            System.out.println(a[i]);

    }
}
