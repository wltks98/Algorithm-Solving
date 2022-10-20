// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1504.java

import java.io.PrintStream;
import java.util.*;

public class p1504
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

        Node(int vertex, int weight)
        {
            this.vertex = vertex;
            this.weight = weight;
        }
    }


    public p1504()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = sc.nextInt();
        list = new ArrayList[n + 1];
        distance = new int[n + 1];
        for(int i = 1; i <= n; i++)
            list[i] = new ArrayList();

        for(int i = 0; i < e; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        long answer1 = 0L;
        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, n);
        long answer2 = 0L;
        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, n);
        if(Math.min(answer1, answer2) >= (long)INF)
        {
            System.out.println(-1);
            return;
        } else
        {
            System.out.println(Math.min(answer1, answer2));
            return;
        }
    }

    private static int dijkstra(int start, int end)
    {
        distance = new int[n + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
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
        return distance[end];
    }

    static ArrayList list[];
    private static int n;
    private static int e;
    private static int distance[];
    private static int INF = 0x7fffffff;

}
