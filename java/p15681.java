// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p15681.java

import java.io.*;
import java.util.*;

public class p15681
{

    public p15681()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());
        list = new ArrayList[n + 1];
        dp = new int[n + 1];
        visit = new boolean[n + 1];
        for(int i = 0; i < list.length; i++)
            list[i] = new ArrayList();

        for(int i = 1; i < n; i++)
        {
            stk = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            list[u].add(Integer.valueOf(v));
            list[v].add(Integer.valueOf(u));
        }

        dfs(r);
        StringBuffer sb = new StringBuffer();
        while(q-- > 0) 
        {
            int query = Integer.parseInt(br.readLine());
            sb.append(dp[query]).append("\n");
        }
        System.out.println(sb);
    }

    public static int dfs(int now)
    {
        if(dp[now] != 0)
            return dp[now];
        visit[now] = true;
        int count = 1;
        for(Iterator iterator = list[now].iterator(); iterator.hasNext();)
        {
            int node = ((Integer)iterator.next()).intValue();
            if(!visit[node])
                count += dfs(node);
        }

        dp[now] = count;
        return dp[now];
    }

    static ArrayList list[];
    static boolean visit[];
    static int dp[];
}
