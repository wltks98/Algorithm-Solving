// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p7579.java

import java.io.*;
import java.util.StringTokenizer;

public class p7579
{

    public p7579()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 10001;
        StringTokenizer input = new StringTokenizer(br.readLine());
        int app_num = Integer.parseInt(input.nextToken());
        int memory_target = Integer.parseInt(input.nextToken());
        int dp[] = new int[10001];
        int app[][] = new int[app_num][2];
        for(int x = 0; x < 2; x++)
        {
            StringTokenizer list = new StringTokenizer(br.readLine());
            for(int y = 0; y < app_num; y++)
                app[y][x] = Integer.parseInt(list.nextToken());

        }

        for(int x = 0; x < app_num; x++)
        {
            for(int y = 10000; y >= app[x][1]; y--)
                dp[y] = Math.max(dp[y], dp[y - app[x][1]] + app[x][0]);

        }

        for(int x = 0; x <= 10000; x++)
            if(dp[x] >= memory_target && x < answer)
                answer = x;

        System.out.println(answer);
        br.close();
    }
}
