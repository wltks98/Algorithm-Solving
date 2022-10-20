// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1562.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1562
{

    public p1562()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long dp[][][] = new long[n + 1][11][1024];
        for(int i = 1; i < 10; i++)
            dp[1][i][1 << i] = 1L;

        for(int i = 2; i < n + 1; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                for(int k = 0; k < 1024; k++)
                {
                    int bit = k | 1 << j;
                    if(j == 0)
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % (long)MOD;
                    else
                    if(j == 9)
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % (long)MOD;
                    else
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % (long)MOD;
                }

            }

        }

        long sum = 0L;
        for(int i = 0; i < 10; i++)
            sum = (sum + dp[n][i][1023]) % (long)MOD;

        System.out.println(sum);
    }

    static int MOD = 0x3b9aca00;

}
