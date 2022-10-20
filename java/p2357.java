// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2357.java

import java.io.*;
import java.util.StringTokenizer;

public class p2357
{

    public p2357()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for(int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        minTree = new int[N * 4];
        maxTree = new int[N * 4];
        minInit(1, N, 1);
        maxInit(1, N, 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append((new StringBuilder(String.valueOf(minFind(1, N, 1, left, right)))).append(" ").append(maxFind(1, N, 1, left, right)).append("\n").toString());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int minInit(int start, int end, int node)
    {
        if(start == end)
        {
            return minTree[node] = arr[start];
        } else
        {
            int mid = (start + end) / 2;
            return minTree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
        }
    }

    public static int maxInit(int start, int end, int node)
    {
        if(start == end)
        {
            return maxTree[node] = arr[start];
        } else
        {
            int mid = (start + end) / 2;
            return maxTree[node] = Math.max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
        }
    }

    public static int minFind(int start, int end, int node, int left, int right)
    {
        if(right < start || end < left)
            return 0x7fffffff;
        if(left <= start && end <= right)
        {
            return minTree[node];
        } else
        {
            int mid = (start + end) / 2;
            return Math.min(minFind(start, mid, node * 2, left, right), minFind(mid + 1, end, node * 2 + 1, left, right));
        }
    }

    public static int maxFind(int start, int end, int node, int left, int right)
    {
        if(right < start || end < left)
            return 0x80000000;
        if(left <= start && end <= right)
        {
            return maxTree[node];
        } else
        {
            int mid = (start + end) / 2;
            return Math.max(maxFind(start, mid, node * 2, left, right), maxFind(mid + 1, end, node * 2 + 1, left, right));
        }
    }

    static int arr[];
    static int minTree[];
    static int maxTree[];
}
