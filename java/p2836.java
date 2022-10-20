// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2836.java

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p2836
{
    private static class Point
        implements Comparable
    {

        public int compareTo(Point o)
        {
            int x = l - o.l;
            if(x == 0)
                x = r - o.r;
            return x;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Point)obj);
        }

        int l;
        int r;

        Point(int l, int r)
        {
            this.l = l;
            this.r = r;
        }
    }


    public p2836()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue q = new PriorityQueue();
        Point p;
        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a > b)
            {
                p = new Point(a, b);
                q.add(p);
            }
        }

        int left = 0;
        int right = 0;
        int length = 0;
        p = (Point)q.poll();
        left = p.l;
        length += p.l - p.r;
        while(!q.isEmpty()) 
        {
            Point p2 = (Point)q.poll();
            if(p2.r <= left)
            {
                length += p2.l - left;
                left = p2.l;
            } else
            {
                length += p2.l - p2.r;
                left = p2.l;
            }
        }
        System.out.println(m + 2 * length);
    }
}
