// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2156.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2156
{

    public p2156()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        dp = new Integer[N + 1];
        arr = new int[N + 1];
        for(int i = 1; i < N + 1; i++)
            arr[i] = in.nextInt();

        dp[0] = Integer.valueOf(0);
        dp[1] = Integer.valueOf(arr[1]);
        if(N > 1)
            dp[2] = Integer.valueOf(arr[1] + arr[2]);
        System.out.println(recur(N));
    }

    static int recur(int N)
    {
        if(dp[N] == null)
            dp[N] = Integer.valueOf(Math.max(Math.max(recur(N - 2), recur(N - 3) + arr[N - 1]) + arr[N], recur(N - 1)));
        return dp[N].intValue();
    }

    static Integer dp[];
    static int arr[];
}
