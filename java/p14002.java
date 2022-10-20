// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p14002.java

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14002
{

    public p14002()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        list = new int[N + 1];
        dp = new int[N + 1];
        tmp = new int[N + 1];
        int result = 0;
        int resultIdx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for(int j = 0; j < i; j++)
                if(list[i] > list[j] && dp[j] + 1 > dp[i])
                {
                    dp[i] = dp[j] + 1;
                    tmp[i] = j;
                }

            if(dp[i] > result)
            {
                result = dp[i];
                resultIdx = i;
            }
        }

        int answer[] = new int[result];
        int index = resultIdx;
        for(int i = result - 1; i >= 0; i--)
        {
            answer[i] = list[index];
            index = tmp[index];
        }

        bw.write((new StringBuilder(String.valueOf(result))).append("\n").toString());
        for(int i = 0; i < result; i++)
            bw.write((new StringBuilder(String.valueOf(answer[i]))).append(" \n").toString());

        System.out.println(Arrays.toString(tmp));
        bw.flush();
        br.close();
        bw.close();
    }

    static int N;
    static int list[];
    static int dp[];
    static int tmp[];
}
