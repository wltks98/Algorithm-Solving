// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2618.java

import java.io.*;
import java.util.StringTokenizer;

public class p2618
{

    public p2618()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        for(int i = 1; i <= W; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write((new StringBuilder(String.valueOf(policeSolution(1, 0, 0)))).append("\n").toString());
        int firstidx = 0;
        int secondidx = 0;
        for(int i = 1; i <= W; i++)
        {
            int dist1 = distance(1, firstidx, i);
            if(dp[firstidx][secondidx] - dist1 == dp[i][secondidx])
            {
                firstidx = i;
                bw.write("1\n");
            } else
            {
                secondidx = i;
                bw.write("2\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int policeSolution(int event, int first, int second)
    {
        if(event > W)
            return 0;
        if(dp[first][second] != 0)
        {
            return dp[first][second];
        } else
        {
            int one = policeSolution(event + 1, event, second) + distance(1, first, event);
            int two = policeSolution(event + 1, first, event) + distance(2, second, event);
            dp[first][second] = Math.min(one, two);
            return dp[first][second];
        }
    }

    static int distance(int type, int start, int end)
    {
        int x_start = position[start][0];
        int y_start = position[start][1];
        int x_end = position[end][0];
        int y_end = position[end][1];
        if(start == 0)
            if(type == 1)
                x_start = y_start = 1;
            else
                x_start = y_start = N;
        return Math.abs(x_start - x_end) + Math.abs(y_start - y_end);
    }

    static int N;
    static int W;
    static int dp[][] = new int[1002][1002];
    static int position[][] = new int[1002][2];

}
