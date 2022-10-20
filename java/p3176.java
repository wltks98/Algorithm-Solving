// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p3176.java

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p3176
{
    static class edge
    {

        int target;
        int cost;

        public edge(int target, int cost)
        {
            this.target = target;
            this.cost = cost;
        }
    }


    public p3176()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        K = 0;
        for(int i = 1; i <= N; i *= 2)
            K++;

        depth = new int[N + 1];
        parent = new int[K][N + 1];
        minDist = new int[K][N + 1];
        maxDist = new int[K][N + 1];
        tree = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            tree[i] = new ArrayList();

        for(int i = 1; i <= N - 1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new edge(b, c));
            tree[b].add(new edge(a, c));
        }

        dfs(1, 1);
        fillParent();
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= M; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lca(a, b);
            sb.append((new StringBuilder(String.valueOf(min))).append(" ").append(max).append("\n").toString());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int id, int cnt)
    {
        depth[id] = cnt;
        int len = tree[id].size();
        for(int i = 0; i < len; i++)
        {
            edge next = (edge)tree[id].get(i);
            if(depth[next.target] == 0)
            {
                dfs(next.target, cnt + 1);
                parent[0][next.target] = id;
                minDist[0][next.target] = next.cost;
                maxDist[0][next.target] = next.cost;
            }
        }

    }

    static void fillParent()
    {
        for(int i = 1; i < K; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
                minDist[i][j] = Math.min(minDist[i - 1][j], minDist[i - 1][parent[i - 1][j]]);
                maxDist[i][j] = Math.max(maxDist[i - 1][j], maxDist[i - 1][parent[i - 1][j]]);
            }

        }

    }

    static void lca(int a, int b)
    {
        if(depth[a] < depth[b])
        {
            int tmp = a;
            a = b;
            b = tmp;
        }
        min = 0x7fffffff;
        max = -1;
        for(int i = K - 1; i >= 0; i--)
            if(Math.pow(2D, i) <= (double)(depth[a] - depth[b]))
            {
                min = Math.min(min, minDist[i][a]);
                max = Math.max(max, maxDist[i][a]);
                a = parent[i][a];
            }

        if(a == b)
            return;
        for(int i = K - 1; i >= 0; i--)
            if(parent[i][a] != parent[i][b])
            {
                min = Math.min(min, Math.min(minDist[i][a], minDist[i][b]));
                max = Math.max(max, Math.max(maxDist[i][a], maxDist[i][b]));
                a = parent[i][a];
                b = parent[i][b];
            }

        min = Math.min(min, Math.min(minDist[0][a], minDist[0][b]));
        max = Math.max(max, Math.max(maxDist[0][a], maxDist[0][b]));
    }

    static int N;
    static int K;
    static int M;
    static int depth[];
    static int parent[][];
    static ArrayList tree[];
    static int minDist[][];
    static int maxDist[][];
    static int min;
    static int max;
}
