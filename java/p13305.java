// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p13305.java

import java.io.PrintStream;
import java.util.Scanner;

public class p13305
{

    public p13305()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long dist[] = new long[N - 1];
        long cost[] = new long[N];
        for(int i = 0; i < N - 1; i++)
            dist[i] = in.nextLong();

        for(int i = 0; i < N; i++)
            cost[i] = in.nextLong();

        for(int i = 0; i < N - 1; i++)
            if(cost[i] < cost[i + 1])
                cost[i + 1] = cost[i];

        long value = 0L;
        for(int i = 0; i < N - 1; i++)
            value += cost[i] * dist[i];

        System.out.println(value);
    }
}
