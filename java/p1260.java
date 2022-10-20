// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1260.java

import java.io.PrintStream;
import java.util.*;

public class p1260
{

    public p1260()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        map = new int[v + 1][v + 1];
        visit = new boolean[v + 1];
        for(int i = 0; i < m; i++)
        {
            int l = sc.nextInt();
            int r = sc.nextInt();
            map[l][r] = 1;
            map[r][l] = 1;
        }

        visit[start] = true;
        System.out.print((new StringBuilder(String.valueOf(start))).append(" ").toString());
        dfs(start);
        System.out.println();
        visit = new boolean[v + 1];
        visit[start] = true;
        bfs(start);
    }

    private static void bfs(int index)
    {
        q.add(Integer.valueOf(index));
        visit[index] = true;
        System.out.print((new StringBuilder(String.valueOf(index))).append(" ").toString());
        while(!q.isEmpty()) 
        {
            int current_v = ((Integer)q.poll()).intValue();
            for(int i = 1; i < v + 1; i++)
                if(!visit[i] && map[current_v][i] == 1)
                {
                    System.out.print((new StringBuilder(String.valueOf(i))).append(" ").toString());
                    visit[i] = true;
                    q.add(Integer.valueOf(i));
                }

        }
        System.out.println();
    }

    private static void dfs(int index)
    {
        for(int i = 1; i < v + 1; i++)
            if(!visit[i] && map[index][i] == 1)
            {
                System.out.print((new StringBuilder(String.valueOf(i))).append(" ").toString());
                visit[i] = true;
                dfs(i);
            }

    }

    private static int m;
    private static int v;
    private static int start;
    private static int map[][];
    private static boolean visit[];
    private static Queue q = new LinkedList();

}
