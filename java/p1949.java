// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1949.java

import java.io.*;
import java.util.*;

public class p1949
{

    public p1949()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        people = new int[n + 1];
        node_list = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        check = new boolean[n + 1];
        for(int i = 0; i < n + 1; i++)
            node_list[i] = new ArrayList();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++)
            people[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n - 1; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node_list[b].add(Integer.valueOf(a));
            node_list[a].add(Integer.valueOf(b));
        }

        traversal(1);
        if(dp[1][1] > dp[1][0])
            System.out.println(dp[1][1]);
        else
            System.out.println(dp[1][0]);
    }

    static void traversal(int pos)
    {
        int child_num = node_list[pos].size();
        dp[pos][0] = 0;
        dp[pos][1] = people[pos];
        if(child_num == 0)
            return;
        check[pos] = true;
        for(Iterator iterator = node_list[pos].iterator(); iterator.hasNext();)
        {
            int child = ((Integer)iterator.next()).intValue();
            if(!check[child])
            {
                traversal(child);
                if(dp[child][0] > dp[child][1])
                    dp[pos][0] += dp[child][0];
                else
                    dp[pos][0] += dp[child][1];
                dp[pos][1] += dp[child][0];
            }
        }

        check[pos] = false;
    }

    static List node_list[];
    static int people[];
    static int dp[][];
    static boolean check[];
}
