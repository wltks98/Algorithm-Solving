// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p4195.java

import java.io.*;
import java.util.*;

public class p4195
{

    public p4195()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) 
        {
            int F = Integer.parseInt(br.readLine());
            parent = new int[F * 2];
            level = new int[F * 2];
            for(int i = 0; i < F * 2; i++)
            {
                parent[i] = i;
                level[i] = 1;
            }

            int idx = 0;
            Map map = new HashMap();
            for(int i = 0; i < F; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if(!map.containsKey(a))
                    map.put(a, Integer.valueOf(idx++));
                if(!map.containsKey(b))
                    map.put(b, Integer.valueOf(idx++));
                sb.append((new StringBuilder(String.valueOf(union(((Integer)map.get(a)).intValue(), ((Integer)map.get(b)).intValue())))).append("\n").toString());
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int x)
    {
        if(x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    public static int union(int x, int y)
    {
        x = find(x);
        y = find(y);
        if(x != y)
        {
            parent[y] = x;
            level[x] += level[y];
            level[y] = 1;
        }
        return level[x];
    }

    static int parent[];
    static int level[];
}
