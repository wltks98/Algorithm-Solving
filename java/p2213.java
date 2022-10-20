// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2213.java

import java.io.*;
import java.util.*;

public class p2213
{

    public p2213()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        weight = new int[n + 1];
        node_list = new ArrayList[n + 1];
        memo = new int[n + 1][2];
        check = new boolean[n + 1];
        res = new ArrayList();
        for(int i = 0; i < n + 1; i++)
            node_list[i] = new ArrayList();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++)
            weight[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n - 1; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node_list[b].add(Integer.valueOf(a));
            node_list[a].add(Integer.valueOf(b));
        }

        traversal(1);
        if(memo[1][1] > memo[1][0])
        {
            System.out.println(memo[1][1]);
            trace(1, 1);
        } else
        {
            System.out.println(memo[1][0]);
            trace(1, 0);
        }
        Collections.sort(res);
        int num;
        for(Iterator iterator = res.iterator(); iterator.hasNext(); System.out.print((new StringBuilder(String.valueOf(num))).append(" ").toString()))
            num = ((Integer)iterator.next()).intValue();

    }

    static void traversal(int pos)
    {
        int child_num = node_list[pos].size();
        memo[pos][0] = 0;
        memo[pos][1] = weight[pos];
        if(child_num == 0)
            return;
        check[pos] = true;
        for(Iterator iterator = node_list[pos].iterator(); iterator.hasNext();)
        {
            int child = ((Integer)iterator.next()).intValue();
            if(!check[child])
            {
                traversal(child);
                if(memo[child][0] > memo[child][1])
                    memo[pos][0] += memo[child][0];
                else
                    memo[pos][0] += memo[child][1];
                memo[pos][1] += memo[child][0];
            }
        }

        check[pos] = false;
    }

    static void trace(int pos, int attend)
    {
        check[pos] = true;
        if(attend == 1)
        {
            res.add(Integer.valueOf(pos));
            for(int i = 0; i < node_list[pos].size(); i++)
            {
                int next = ((Integer)node_list[pos].get(i)).intValue();
                if(!check[next])
                    trace(next, 0);
            }

        } else
        {
            for(int i = 0; i < node_list[pos].size(); i++)
            {
                int next = ((Integer)node_list[pos].get(i)).intValue();
                if(!check[next])
                    if(memo[next][1] > memo[next][0])
                        trace(next, 1);
                    else
                        trace(next, 0);
            }

        }
        check[pos] = false;
    }

    static List node_list[];
    static int weight[];
    static int memo[][];
    static boolean check[];
    static List res;
}
