// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p12852.java

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class p12852
{

    public p12852()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, 0x3b9aca00);
        dp[N] = 0;
        for(int i = N; i >= 1; i--)
        {
            int minValue = dp[i] + 1;
            if(i % 3 == 0)
                dp[i / 3] = Math.min(dp[i / 3], minValue);
            if(i % 2 == 0)
                dp[i / 2] = Math.min(dp[i / 2], minValue);
            dp[i - 1] = Math.min(dp[i - 1], minValue);
        }

        sb.append((new StringBuilder(String.valueOf(dp[1]))).append("\n").toString());
        int minValue = dp[1];
        Stack stack = new Stack();
        for(int i = 1; i <= N; i++)
            if(minValue == dp[i])
            {
                stack.push(Integer.valueOf(i));
                if(i * 3 <= N && dp[i * 3] == minValue - 1)
                    i = i * 3 - 1;
                else
                if(i * 2 <= N && dp[i * 2] == minValue - 1)
                    i = i * 2 - 1;
                minValue--;
            }

        for(; !stack.isEmpty(); sb.append((new StringBuilder()).append(stack.pop()).append(" ").toString()));
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static int N;
    static int dp[];
    static final int INF = 0x3b9aca00;
}
