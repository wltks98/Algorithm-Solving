// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1086.java

import java.io.*;
import java.util.Arrays;

public class p1086
{

    public p1086()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new char[N][];
        for(int i = 0; i < N; i++)
            arr[i] = br.readLine().toCharArray();

        K = Integer.parseInt(br.readLine());
        fibo = new long[N + 1];
        fibo[1] = 1L;
        for(int i = 2; i <= N; i++)
            fibo[i] = (long)i * fibo[i - 1];

        dp = new long[K][1 << N];
        dpMod = new int[K][N];
        for(int k = 0; k < K; k++)
        {
            Arrays.fill(dp[k], -1L);
            Arrays.fill(dpMod[k], -1);
        }

        p = memoi(0, 0, 0);
        q = fibo[N];
        if(p == 0L)
        {
            q = 1L;
        } else
        {
            long gcd = GCD(p, q);
            p /= gcd;
            q /= gcd;
        }
        System.out.println((new StringBuilder(String.valueOf(p))).append("/").append(q).toString());
    }

    public static int getMod(int mod, int n)
    {
        if(dpMod[mod][n] != -1)
            return dpMod[mod][n];
        int cur = mod;
        for(int j = 0; j < arr[n].length; j++)
        {
            cur *= 10;
            cur = ((cur + arr[n][j]) - 48) % K;
        }

        return dpMod[mod][n] = cur;
    }

    public static long memoi(int mod, int cnt, int flag)
    {
        if(dp[mod][flag] != -1L)
            return dp[mod][flag];
        if(cnt == N)
            return dp[mod][flag] = mod != 0 ? 0L : 1L;
        long sum = 0L;
        for(int i = 0; i < N; i++)
            if((flag & 1 << i) != 1 << i)
                sum += memoi(getMod(mod, i), cnt + 1, flag | 1 << i);

        return dp[mod][flag] = sum;
    }

    static long GCD(long a, long b)
    {
        if(a > b)
        {
            long tmp = a;
            a = b;
            b = tmp;
        }
        long tmp;
        for(; a % b != 0L; b = tmp)
        {
            tmp = a % b;
            a = b;
        }

        return b;
    }

    static int N;
    static int K;
    static char arr[][];
    static long p;
    static long q;
    static long fibo[];
    static long dp[][];
    static int dpMod[][];
}
