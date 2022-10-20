// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1517.java

import java.io.*;
import java.util.*;

public class p1517
{
    static class FenwickTree
    {

        void add(int pos, int val)
        {
            for(; pos < tree.length; pos += pos & -pos)
                tree[pos] += val;

        }

        int sum(int pos)
        {
            int ret = 0;
            for(; pos > 0; pos -= pos & -pos)
                ret += tree[pos];

            return ret;
        }

        int tree[];

        FenwickTree(int n)
        {
            tree = new int[n + 1];
        }
    }


    public p1517()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int S[] = new int[N];
        for(int i = 0; i < N; i++)
            S[i] = Integer.parseInt(st.nextToken());

        FenwickTree t = new FenwickTree(N);
        for(int i = 1; i <= N; i++)
            t.add(i, 1);

        Map map = new HashMap();
        for(int i = 0; i < N; i++)
        {
            PriorityQueue pq = (PriorityQueue)map.get(Integer.valueOf(S[i]));
            if(pq == null)
                map.put(Integer.valueOf(S[i]), pq = new PriorityQueue());
            pq.offer(Integer.valueOf(i + 1));
        }

        Arrays.sort(S);
        long ret = 0L;
        for(int i = 0; i < N; i++)
        {
            int x;
            for(PriorityQueue pq = (PriorityQueue)map.get(Integer.valueOf(S[i])); !pq.isEmpty(); t.add(x, -1))
            {
                x = ((Integer)pq.poll()).intValue();
                ret += t.sum(x) - 1;
            }

        }

        System.out.println(ret);
    }
}
