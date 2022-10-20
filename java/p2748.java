// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2748.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2748
{

    public p2748()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        sum = fib(n);
        System.out.println(sum);
    }

    static int fib(int n)
    {
        if(n == 1 || n == 2)
            return 1;
        if(n > 2)
            return fib(n - 1) + fib(n - 2);
        else
            return 0;
    }

    static int s = 0;

}
