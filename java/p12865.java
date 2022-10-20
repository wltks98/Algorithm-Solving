// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p12865.java

import java.io.PrintStream;
import java.util.Scanner;

public class p12865
{

    public p12865()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int dp[][] = new int[N + 1][K + 1];
        int w[] = new int[N + 1];
        int v[] = new int[N + 1];
        for(int i = 1; i <= N; i++)
        {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= K; j++)
            {
                dp[i][j] = dp[i - 1][j];
                if(j - w[i] >= 0)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            }

        }

        System.out.println(dp[N][K]);
    }
}
