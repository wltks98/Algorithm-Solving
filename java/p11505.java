// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11505.java

import java.io.*;
import java.util.StringTokenizer;

public class p11505
{

    public p11505()
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
        int K = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        for(int i = 1; i <= N; i++)
            arr[i] = Long.parseLong(br.readLine());

        tree = new long[N * 4];
        init(1, N, 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M + K; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1)
            {
                arr[b] = c;
                update(1, N, 1, b, c);
            } else
            if(a == 2)
                sb.append((new StringBuilder(String.valueOf(mul(1, N, 1, b, (int)c)))).append("\n").toString());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long init(int start, int end, int node)
    {
        if(start == end)
        {
            return tree[node] = arr[start];
        } else
        {
            int mid = (start + end) / 2;
            return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % (long)MOD;
        }
    }

    public static long mul(int start, int end, int node, int left, int right)
    {
        if(left > end || right < start)
            return 1L;
        if(left <= start && end <= right)
        {
            return tree[node];
        } else
        {
            int mid = (start + end) / 2;
            return (mul(start, mid, node * 2, left, right) * mul(mid + 1, end, node * 2 + 1, left, right)) % (long)MOD;
        }
    }

    public static long update(int start, int end, int node, int idx, long val)
    {
        if(idx < start || idx > end)
            return tree[node];
        if(start == end)
        {
            return tree[node] = val;
        } else
        {
            int mid = (start + end) / 2;
            return tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val)) % (long)MOD;
        }
    }

    static int MOD = 0x3b9aca07;
    static long arr[];
    static long tree[];

}
