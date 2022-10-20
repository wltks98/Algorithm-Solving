// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11438.java

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class p11438
{

    public p11438()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxDepth = 0;
        for(int check = 1; check <= n;)
        {
            check <<= 1;
            maxDepth++;
        }

        list = new ArrayList();
        for(int i = 0; i < n + 1; i++)
            list.add(new ArrayList());

        depth = new int[n + 1];
        parent = new int[n + 1][maxDepth + 1];
        for(int i = 0; i < n - 1; i++)
        {
            String s[] = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            ((ArrayList)list.get(a)).add(Integer.valueOf(b));
            ((ArrayList)list.get(b)).add(Integer.valueOf(a));
        }

        dfs(1, 1);
        setParent(n, maxDepth);
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++)
        {
            String s[] = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            System.out.println(solve(a, b, maxDepth));
        }

    }

    public static void dfs(int node, int cnt)
    {
        depth[node] = cnt;
        for(Iterator iterator = ((ArrayList)list.get(node)).iterator(); iterator.hasNext();)
        {
            int n = ((Integer)iterator.next()).intValue();
            if(depth[n] == 0)
            {
                parent[n][0] = node;
                dfs(n, cnt + 1);
            }
        }

    }

    public static void setParent(int n, int maxDepth)
    {
        for(int i = 1; i < maxDepth; i++)
        {
            for(int j = 1; j <= n; j++)
                parent[j][i] = parent[parent[j][i - 1]][i - 1];

        }

    }

    public static int solve(int a, int b, int maxDepth)
    {
        if(depth[a] > depth[b])
        {
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i = maxDepth - 1; i >= 0; i--)
            if(depth[a] <= depth[parent[b][i]])
                b = parent[b][i];

        if(a == b)
            return a;
        for(int i = maxDepth - 1; i >= 0; i--)
            if(parent[a][i] != parent[b][i])
            {
                a = parent[a][i];
                b = parent[b][i];
            }

        return parent[a][0];
    }

    static ArrayList list;
    static int depth[];
    static int parent[][];
}
