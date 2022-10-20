// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1707.java

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1707
{

    public p1707()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int k = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < k; tc++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            isVisited = new boolean[v + 1];
            map = new ArrayList[v + 1];
            for(int i = 1; i <= v; i++)
                map[i] = new ArrayList();

            colormap = new char[v + 1];
            for(int i = 0; i < e; i++)
            {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from].add(Integer.valueOf(to));
                map[to].add(Integer.valueOf(from));
            }

            isBinaryGraph = true;
            for(int u = 1; u <= v; u++)
                if(!isVisited[u])
                    dfs(u, true);

            System.out.println(isBinaryGraph ? "YES" : "NO");
        }

    }

    public static void dfs(int num, boolean isRed)
    {
        if(!isBinaryGraph)
            return;
        isVisited[num] = true;
        colormap[num] = isRed ? 'r' : 'b';
        for(int i = 0; i < map[num].size(); i++)
            if(!isVisited[((Integer)map[num].get(i)).intValue()])
                dfs(((Integer)map[num].get(i)).intValue(), !isRed);
            else
            if(colormap[num] == colormap[((Integer)map[num].get(i)).intValue()])
            {
                isBinaryGraph = false;
                return;
            }

    }

    static int v;
    static int e;
    static boolean isBinaryGraph;
    static boolean isVisited[];
    static ArrayList map[];
    static char colormap[];
}
