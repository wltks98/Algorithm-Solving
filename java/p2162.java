// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2162.java

import java.io.*;
import java.util.StringTokenizer;

public class p2162
{
    static class Line
    {

        long x1;
        long y1;
        long x2;
        long y2;

        public Line(long x1, long y1, long x2, long y2)
        {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }


    public p2162()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Line l[] = new Line[N + 1];
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++)
            parent[i] = i;

        for(int i = 1; i <= N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            l[i] = new Line(x1, y1, x2, y2);
        }

        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
                if(i != j)
                {
                    int l_parent = find(i);
                    int r_parent = find(j);
                    if(l_parent != r_parent && isCrossed(l[i], l[j]))
                        union(i, j);
                }

        }

        int cnt[] = new int[N + 1];
        int max = 0;
        int size = 0;
        for(int i = 1; i <= N; i++)
            cnt[parent[i]]++;

        for(int i = 1; i <= N; i++)
        {
            if(max < cnt[i])
                max = cnt[i];
            if(cnt[i] != 0)
                size++;
        }

        bw.write((new StringBuilder(String.valueOf(size))).append("\n").append(max).append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int ccw(long x1, long y1, long x2, long y2, 
            long x3, long y3)
    {
        long result = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if(result == 0L)
            return 0;
        else
            return result <= 0L ? -1 : 1;
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
        else
            return;
    }

    public static boolean isCrossed(Line l1, Line l2)
    {
        long check1 = ccw(l1.x1, l1.y1, l1.x2, l1.y2, l2.x1, l2.y1) * ccw(l1.x1, l1.y1, l1.x2, l1.y2, l2.x2, l2.y2);
        long check2 = ccw(l2.x1, l2.y1, l2.x2, l2.y2, l1.x1, l1.y1) * ccw(l2.x1, l2.y1, l2.x2, l2.y2, l1.x2, l1.y2);
        if(check1 == 0L && check2 == 0L)
            return isOverlapped(l1, l2);
        return check1 <= 0L && check2 <= 0L;
    }

    public static boolean isOverlapped(Line l1, Line l2)
    {
        if(Math.max(l1.x1, l1.x2) < Math.min(l2.x1, l2.x2))
            return false;
        if(Math.max(l2.x1, l2.x2) < Math.min(l1.x1, l1.x2))
            return false;
        if(Math.max(l1.y1, l1.y2) < Math.min(l2.y1, l2.y2))
            return false;
        return Math.max(l2.y1, l2.y2) >= Math.min(l1.y1, l1.y2);
    }

    static int parent[];
}
