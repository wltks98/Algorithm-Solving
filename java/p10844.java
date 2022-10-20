// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10844.java

import java.io.*;

public class p10844
{

    public p10844()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        int dp[][] = new int[101][10];
        int N = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        for(int i = 1; i <= 9; i++)
            dp[1][i] = 1;

        for(int i = 1; i < 9; i++)
            dp[2][i] = 2;

        dp[2][9] = 1;
        for(int i = 3; i <= N; i++)
        {
            for(int j = 1; j <= 9; j++)
            {
                if(j == 1)
                    dp[i][j] = dp[i - 2][j] + dp[i - 1][j + 1];
                else
                if(j == 9)
                    dp[i][j] = dp[i - 1][8];
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= 0x3b9aca00;
            }

        }

        long sum = 0L;
        for(int i = 0; i < 10; i++)
            sum += dp[N][i];

        sum %= 0x3b9aca00L;
        System.out.println(sum);
    }

    public static final int MOD = 0x3b9aca00;
}
