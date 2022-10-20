// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1520.java

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class p1520
{

    public p1520()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++)
        {
            Arrays.fill(dp[i], -1);
            for(int j = 1; j <= M; j++)
                arr[i][j] = scan.nextInt();

        }

        System.out.println(dp_find(1, 1));
    }

    public static int dp_find(int sn, int sm)
    {
        if(N == sn && M == sm)
            return 1;
        if(dp[sn][sm] == -1)
        {
            dp[sn][sm] = 0;
            if(sn > 0 && arr[sn][sm] > arr[sn - 1][sm])
                dp[sn][sm] += dp_find(sn - 1, sm);
            if(sm > 0 && arr[sn][sm] > arr[sn][sm - 1])
                dp[sn][sm] += dp_find(sn, sm - 1);
            if(sn < N && arr[sn][sm] > arr[sn + 1][sm])
                dp[sn][sm] += dp_find(sn + 1, sm);
            if(sm < M && arr[sn][sm] > arr[sn][sm + 1])
                dp[sn][sm] += dp_find(sn, sm + 1);
        }
        return dp[sn][sm];
    }

    static int N;
    static int M;
    static int arr[][];
    static int dp[][];
}
