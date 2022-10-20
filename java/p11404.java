// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11404.java

import java.io.*;
import java.util.StringTokenizer;

public class p11404
{

    public p11404()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());
        distance = new int[cityCount + 1][cityCount + 1];
        for(int i = 1; i <= cityCount; i++)
        {
            for(int j = 1; j <= cityCount; j++)
                if(i != j)
                    distance[i][j] = 0x3b9aca00;

        }

        while(busCount-- > 0) 
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            distance[start][end] = Math.min(distance[start][end], time);
        }
        floydWarshall();
        print();
    }

    public static void floydWarshall()
    {
        for(int k = 1; k <= cityCount; k++)
        {
            for(int i = 1; i <= cityCount; i++)
            {
                for(int j = 1; j <= cityCount; j++)
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);

            }

        }

    }

    public static void print()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= cityCount; i++)
        {
            for(int j = 1; j <= cityCount; j++)
                if(distance[i][j] >= 0x3b9aca00)
                    sb.append("0 ");
                else
                    sb.append((new StringBuilder(String.valueOf(distance[i][j]))).append(" ").toString());

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int cityCount;
    public static int distance[][];
    public static final int INF = 0x3b9aca00;
}
