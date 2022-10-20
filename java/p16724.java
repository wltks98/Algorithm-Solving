// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p16724.java

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p16724
{
    static class Point
    {

        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }


    public p16724()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        parent = new int[n * m];
        int index = 0;
        for(int i = 0; i < n; i++)
        {
            String str = br.readLine();
            for(int j = 0; j < m; j++)
            {
                map[i][j] = str.charAt(j);
                parent[index] = index++;
            }

        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                int currentX = i * m + j;
                int nextX = findidx(i, j);
                if(find(currentX) != find(nextX))
                    union(currentX, nextX);
            }

        }

        System.out.println(findSaveZone());
    }

    public static int findSaveZone()
    {
        HashSet set = new HashSet();
        for(int i = 0; i < n * m; i++)
            set.add(Integer.valueOf(find(i)));

        return set.size();
    }

    public static int findidx(int x, int y)
    {
        int nx = x;
        int ny = y;
        switch(map[x][y])
        {
        case 68: // 'D'
            nx++;
            break;

        case 85: // 'U'
            nx--;
            break;

        case 76: // 'L'
            ny--;
            break;

        case 82: // 'R'
            ny++;
            break;
        }
        return nx * m + ny;
    }

    private static boolean isSameParent(int x, int y)
    {
        x = find(x);
        y = find(y);
        return x == y;
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
        if(x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static int n;
    static int m;
    static char map[][];
    static int parent[];
}
