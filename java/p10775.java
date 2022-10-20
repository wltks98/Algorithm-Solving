// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10775.java

import java.io.*;

public class p10775
{

    public p10775()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for(int i = 1; i <= G; i++)
            parent[i] = i;

        int ans = 0;
        for(int i = 0; i < P; i++)
        {
            int g = Integer.parseInt(br.readLine());
            int emptyGate = find(g);
            if(emptyGate == 0)
                break;
            ans++;
            union(emptyGate, emptyGate - 1);
        }

        bw.write((new StringBuilder(String.valueOf(ans))).append("\n").toString());
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

    public static void union(int x, int y)
    {
        x = find(x);
        y = find(y);
        if(x != y)
            parent[x] = y;
    }

    static int parent[];
}
