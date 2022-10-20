// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1197.java

import java.io.PrintStream;
import java.util.*;

public class p1197
{
    static class Edge
        implements Comparable
    {

        public int compareTo(Edge o)
        {
            return weight - o.weight;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Edge)obj);
        }

        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight)
        {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }


    public p1197()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        parent = new int[V + 1];
        for(int i = 1; i <= V; i++)
            parent[i] = i;

        for(int e = 0; e < E; e++)
        {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            edgeList.add(new Edge(A, B, C));
        }

        Collections.sort(edgeList);
        for(int i = 0; i < edgeList.size(); i++)
        {
            Edge edge = (Edge)edgeList.get(i);
            if(!isSameParent(edge.start, edge.end))
            {
                answer += edge.weight;
                union(edge.start, edge.end);
            }
        }

        System.out.println(answer);
    }

    private static void union(int x, int y)
    {
        x = find(x);
        y = find(y);
        if(x != y)
            if(x < y)
                parent[y] = x;
            else
                parent[x] = y;
    }

    private static int find(int x)
    {
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    private static boolean isSameParent(int x, int y)
    {
        x = find(x);
        y = find(y);
        return x == y;
    }

    private static int parent[];
    private static ArrayList edgeList = new ArrayList();
    private static int answer = 0;

}
