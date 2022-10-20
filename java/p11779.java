// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11779.java

import java.io.PrintStream;
import java.util.*;

public class p11779
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


    public p11779()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        list = new ArrayList[v + 1];
        distance = new int[v + 1];
        parent = new int[v + 1];
        Arrays.fill(parent, -1);
        for(int i = 1; i <= v; i++)
            list[i] = new ArrayList();

        for(int i = 0; i < e; i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list[u].add(new Node(v, w));
        }

        start = sc.nextInt();
        end = sc.nextInt();
        Arrays.fill(distance, INF);
        distance[start] = 0;
        dijkstra();
        int dest = distance[end];
        int i = end;
        Stack stack = new Stack();
        stack.add(Integer.valueOf(end));
        for(; i != start; i = parent[i])
            stack.add(Integer.valueOf(parent[i]));

        System.out.println(dest);
        System.out.println(stack.size());
        for(; !stack.isEmpty(); System.out.print((new StringBuilder()).append(stack.pop()).append(" ").toString()));
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
                        parent[vertex2] = vertex;
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
    private static int end;
    private static int distance[];
    private static int parent[];
    private static int INF = 0x7fffffff;

}
