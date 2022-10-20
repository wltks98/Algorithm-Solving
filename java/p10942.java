// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10942.java

import java.io.PrintStream;
import java.util.Scanner;

public class p10942
{

    public p10942()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
        a = new int[n + 1];
        dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++)
            a[i] = sc.nextInt();

        int m = sc.nextInt();
        for(int i = 1; i <= n; i++)
        {
            dp[i][i] = 1;
            for(int k = 1; i - k >= 1 && i + k <= n && a[i - k] == a[i + k]; k++)
                dp[i - k][i + k] = 1;

            if(i + 1 <= n && a[i] == a[i + 1])
            {
                dp[i][i + 1] = 1;
                for(int k2 = 1; i - k2 >= 1 && i + 1 + k2 <= n && a[i - k2] == a[i + 1 + k2]; k2++)
                    dp[i - k2][i + 1 + k2] = 1;

            }
        }

        for(int i = 0; i < m; i++)
        {
            int s = sc.nextInt();
            int e = sc.nextInt();
            sb.append((new StringBuilder(String.valueOf(dp[s][e]))).append("\n").toString());
        }

        System.out.println(sb);
    }

    static int n;
    static int a[];
    static int dp[][];
}
