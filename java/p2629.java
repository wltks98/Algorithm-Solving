// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2629.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2629
{

    public p2629()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        int dp[][] = new int[n][sum + 1];
        dp[0][a[0]] = a[0];
        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j <= sum; j++)
            {
                if(dp[i - 1][j] != 0)
                {
                    dp[i][j] = dp[i - 1][j];
                    dp[i][dp[i][j] + a[i]] = dp[i][j] + a[i];
                    dp[i][Math.abs(dp[i][j] - a[i])] = Math.abs(dp[i][j] - a[i]);
                }
                if(j == a[i])
                    dp[i][j] = a[i];
            }

        }

        int m = sc.nextInt();
        for(int i = 0; i < m; i++)
        {
            int x = sc.nextInt();
            if(x <= sum && dp[n - 1][x] != 0)
                System.out.print("Y ");
            else
                System.out.print("N ");
        }

    }
}
