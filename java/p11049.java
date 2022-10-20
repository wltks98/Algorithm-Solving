// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11049.java

import java.io.PrintStream;
import java.util.Scanner;

public class p11049
{

    public p11049()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N + 1][N + 1];
        arr = new int[N + 1][2];
        for(int i = 1; i <= N; i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        System.out.println((new StringBuilder(String.valueOf(getMinCost(N)))).toString());
    }

    public static int getMinCost(int n)
    {
        for(int j = 2; j <= n; j++)
        {
            int i = 1;
            for(int currJ = j; currJ <= n;)
            {
                double min = (1.0D / 0.0D);
                for(int k = i; k < currJ; k++)
                    min = (double)(dp[i][k] + dp[k + 1][currJ] + arr[i][0] * arr[k][1] * arr[currJ][1]) >= min ? min : dp[i][k] + dp[k + 1][currJ] + arr[i][0] * arr[k][1] * arr[currJ][1];

                dp[i][currJ] = (int)min;
                currJ++;
                i++;
            }

        }

        return dp[1][n];
    }

    static int dp[][];
    static int arr[][];
}
