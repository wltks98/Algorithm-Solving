// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1967.java

import java.io.PrintStream;
import java.util.*;

public class p1967
{
    static class Edge
    {

        public int to;
        public int cost;

        Edge(int to, int cost)
        {
            this.to = to;
            this.cost = cost;
        }
    }


    public p1967()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List a[] = new List[n + 1];
        for(int i = 1; i <= n; i++)
            a[i] = new ArrayList();

        for(int i = 1; i < n; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            a[x].add(new Edge(y, z));
            a[y].add(new Edge(x, z));
        }

        int dist[] = bfs(n, a, 1);
        int start = 1;
        for(int i = 2; i <= n; i++)
            if(dist[i] > dist[start])
                start = i;

        dist = bfs(n, a, start);
        int ans = dist[1];
        for(int i = 2; i <= n; i++)
            if(ans < dist[i])
                ans = dist[i];

        System.out.println(ans);
    }

    public static int[] bfs(int n, List a[], int start)
    {
        boolean check[] = new boolean[n + 1];
        int dist[] = new int[n + 1];
        Queue q = new LinkedList();
        check[start] = true;
        q.add(Integer.valueOf(start));
        while(!q.isEmpty()) 
        {
            int x = ((Integer)q.remove()).intValue();
            for(Iterator iterator = a[x].iterator(); iterator.hasNext();)
            {
                Edge e = (Edge)iterator.next();
                int y = e.to;
                int cost = e.cost;
                if(!check[y])
                {
                    dist[y] = dist[x] + cost;
                    q.add(Integer.valueOf(y));
                    check[y] = true;
                }
            }

        }
        return dist;
    }
}
