// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2004.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2004
{

    public p2004()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long M = in.nextLong();
        long count5 = five_power_n(N) - five_power_n(N - M) - five_power_n(M);
        long count2 = two_power_n(N) - two_power_n(N - M) - two_power_n(M);
        System.out.println(Math.min(count5, count2));
    }

    static long five_power_n(long num)
    {
        int count = 0;
        for(; num >= 5L; num /= 5L)
            count = (int)((long)count + num / 5L);

        return (long)count;
    }

    static long two_power_n(long num)
    {
        int count = 0;
        for(; num >= 2L; num /= 2L)
            count = (int)((long)count + num / 2L);

        return (long)count;
    }
}
