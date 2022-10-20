// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2293.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2293
{

    public p2293()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int coin[] = new int[n];
        int dp[] = new int[k + 1];
        for(int i = 0; i < n; i++)
            coin[i] = sc.nextInt();

        dp[0] = 1;
        for(int i = 0; i < n; i++)
        {
            int currentCoin = coin[i];
            for(int j = currentCoin; j <= k; j++)
                dp[j] += dp[j - currentCoin];

        }

        System.out.println(dp[k]);
    }
}
