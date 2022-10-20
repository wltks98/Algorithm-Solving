// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11657.java

import java.io.*;
import java.util.StringTokenizer;

public class p11657
{
    static class Bus
    {

        int start;
        int end;
        int weight;

        public Bus(int start, int end, int weight)
        {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }


    public p11657()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        busArr = new Bus[m + 1];
        dist = new int[n + 1];
        for(int i = 1; i <= n; i++)
            dist[i] = 0x2faf080;

        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            busArr[i] = new Bus(start, end, time);
        }

        StringBuilder sb = new StringBuilder();
        if(bellmanFord())
        {
            for(int i = 2; i <= n; i++)
                sb.append(dist[i] != 0x2faf080 ? (new StringBuilder(String.valueOf(dist[i]))).append("\n").toString() : "-1\n");

        } else
        {
            sb.append("-1\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static boolean bellmanFord()
    {
        dist[1] = 0;
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                Bus bus = busArr[j];
                if(dist[bus.start] != 0x2faf080 && dist[bus.end] > dist[bus.start] + bus.weight)
                    dist[bus.end] = dist[bus.start] + bus.weight;
            }

        }

        for(int i = 0; i < m; i++)
        {
            Bus bus = busArr[i];
            if(dist[bus.start] != 0x2faf080 && dist[bus.end] > dist[bus.start] + bus.weight)
                return false;
        }

        return true;
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static final int INF = 0x2faf080;
    static int n;
    static int m;
    static int dist[];
    static Bus busArr[];

    static 
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
