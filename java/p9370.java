// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p9370.java

import java.io.*;
import java.util.*;

public class p9370
{
    static class Node
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

        int end;
        int weight;

        public Node(int end, int weight)
        {
            this.end = end;
            this.weight = weight;
        }
    }


    public p9370()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        int testCnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCnt; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            arr = new int[vertex + 1][vertex + 1];
            dist = new int[vertex + 1];
            for(int j = 0; j < arr.length; j++)
                Arrays.fill(arr[j], 0x989680);

            Arrays.fill(dist, 0x989680);
            check = new boolean[vertex + 1];
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            for(int j = 0; j < edge; j++)
            {
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());
                arr[vertex1][vertex2] = arr[vertex2][vertex1] = distance * 2;
            }

            arr[h][g] = arr[g][h] = arr[h][g] - 1;
            answerList = new ArrayList();
            for(int j = 0; j < t; j++)
                answerList.add(Integer.valueOf(Integer.parseInt(br.readLine())));

            solve();
            Collections.sort(answerList);
            for(Iterator iterator = answerList.iterator(); iterator.hasNext();)
            {
                int num = ((Integer)iterator.next()).intValue();
                if(dist[num] % 2 == 1)
                    bw.write((new StringBuilder(String.valueOf(num))).append(" ").toString());
            }

            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    private static void solve()
    {
        dijkstra();
    }

    private static void dijkstra()
    {
        PriorityQueue queue = new PriorityQueue();
        queue.add(new Node(start, 0));
        dist[start] = 0;
        while(!queue.isEmpty()) 
        {
            Node curNode = (Node)queue.poll();
            int cur = curNode.end;
            if(!check[cur])
            {
                check[cur] = true;
                for(int i = 1; i <= vertex; i++)
                    if(!check[i] && dist[i] > dist[cur] + arr[cur][i])
                    {
                        dist[i] = dist[cur] + arr[cur][i];
                        queue.add(new Node(i, dist[i]));
                    }

            }
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static final int INF = 0x989680;
    static int vertex;
    static int edge;
    static int t;
    static int start;
    static int g;
    static int h;
    static int arr[][];
    static int dist[];
    static boolean check[];
    static List answerList;

    static 
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
