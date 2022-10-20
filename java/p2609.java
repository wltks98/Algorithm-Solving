// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2609.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2609
{

    public p2609()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = 0;
        int max = 0x80000000;
        if(a > b)
            x = b;
        else
            x = a;
        for(int i = 1; i <= x; i++)
            if(a % i == 0 && b % i == 0 && max < i)
                max = i;

        System.out.println(max);
        System.out.println((a * b) / max);
    }
}
