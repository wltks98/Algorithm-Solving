// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2533.java

import java.io.PrintStream;
import java.util.*;

public class p2533
{

    public p2533()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adjList = new LinkedList[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        for(int i = 1; i <= N; i++)
            adjList[i] = new LinkedList();

        for(int i = 0; i < N - 1; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList[a].add(Integer.valueOf(b));
            adjList[b].add(Integer.valueOf(a));
        }

        dp(1, -1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void dfs(int cur)
    {
        dp[cur][0] = 0;
        dp[cur][1] = 1;
        visited[cur] = true;
        LinkedList list = adjList[cur];
        for(int i = 0; i < list.size(); i++)
            if(!visited[((Integer)list.get(i)).intValue()])
            {
                dfs(((Integer)list.get(i)).intValue());
                dp[cur][0] += dp[((Integer)list.get(i)).intValue()][1];
                dp[cur][1] += Math.min(dp[((Integer)list.get(i)).intValue()][0], dp[((Integer)list.get(i)).intValue()][1]);
            }

    }

    public static void dp(int cur, int parent)
    {
        dp[cur][0] = 0;
        dp[cur][1] = 1;
        for(Iterator iterator = adjList[cur].iterator(); iterator.hasNext();)
        {
            int next = ((Integer)iterator.next()).intValue();
            if(next != parent)
            {
                dp(next, cur);
                dp[cur][0] += dp[next][1];
                dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }

    }

    public static LinkedList adjList[];
    public static boolean visited[];
    public static int dp[][];
    public static int N;
    public static int answer = 0;

}
