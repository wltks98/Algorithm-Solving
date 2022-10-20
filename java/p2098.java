// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2098.java

import java.io.*;
import java.util.Arrays;

public class p2098
{

    public p2098()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][(1 << N) - 1];
        w = new int[N][N];
        for(int i = 0; i < N; i++)
        {
            String input[] = br.readLine().split(" ");
            for(int j = 0; j < N; j++)
                w[i][j] = Integer.parseInt(input[j]);

        }

        for(int i = 0; i < N; i++)
            Arrays.fill(dp[i], 0xf42400);

        bw.write((new StringBuilder(String.valueOf(dfs(0, 1)))).append("\n").toString());
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < (1 << N) - 1; j++)
                System.out.print((new StringBuilder(String.valueOf(dp[i][j]))).append(" ").toString());

            System.out.println();
        }

        bw.flush();
    }

    public static int dfs(int node, int visit)
    {
        if(visit == (1 << N) - 1)
            if(w[node][0] == 0)
                return 0xf42400;
            else
                return w[node][0];
        if(dp[node][visit] != 0xf42400)
            return dp[node][visit];
        for(int i = 0; i < N; i++)
            if((visit & 1 << i) == 0 && w[node][i] != 0)
                dp[node][visit] = Math.min(dp[node][visit], dfs(i, visit | 1 << i) + w[node][i]);

        return dp[node][visit];
    }

    static int N;
    static int w[][];
    static int dp[][];
    static final int INF = 0xf42400;
}
