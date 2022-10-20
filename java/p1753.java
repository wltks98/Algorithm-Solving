// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1753.java

import java.io.PrintStream;
import java.util.*;

public class p1753
{
    private static class Node
        implements Comparable
    {

        public int compareTo(Node o)
        {
            return weight - o.weight;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Node)obj);
        }

        int vertex;
        int weight;

        public Node(int vertex, int weight)
        {
            this.vertex = vertex;
            this.weight = weight;
        }
    }


    public p1753()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        start = sc.nextInt();
        list = new ArrayList[v + 1];
        distance = new int[v + 1];
        for(int i = 1; i <= v; i++)
            list[i] = new ArrayList();

        Arrays.fill(distance, INF);
        distance[start] = 0;
        for(int i = 0; i < e; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list[u].add(new Node(v, w));
        }

        dijkstra();
        for(int i = 1; i <= v; i++)
            if(distance[i] == INF)
                System.out.println("INF");
            else
                System.out.println(distance[i]);

    }

    private static void dijkstra()
    {
        PriorityQueue queue = new PriorityQueue();
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) 
        {
            Node node = (Node)queue.poll();
            int vertex = node.vertex;
            int weight = node.weight;
            if(distance[vertex] >= weight)
            {
                for(int i = 0; i < list[vertex].size(); i++)
                {
                    int vertex2 = ((Node)list[vertex].get(i)).vertex;
                    int weight2 = ((Node)list[vertex].get(i)).weight + weight;
                    if(distance[vertex2] > weight2)
                    {
                        distance[vertex2] = weight2;
                        queue.add(new Node(vertex2, weight2));
                    }
                }

            }
        }
    }

    static ArrayList list[];
    private static int v;
    private static int e;
    private static int start;
    private static int distance[];
    private static int INF = 0x7fffffff;

}
