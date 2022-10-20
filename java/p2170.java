// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2170.java

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p2170
{
    private static class Point
        implements Comparable
    {

        public int compareTo(Point o)
        {
            return l - o.l;
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


    public p2170()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue q = new PriorityQueue();
        Point p;
        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            p = new Point(a, b);
            q.add(p);
        }

        int left = 0;
        int right = 0;
        int length = 0;
        p = (Point)q.poll();
        left = p.l;
        right = p.r;
        for(int i = 1; i < n; i++)
        {
            Point p2 = (Point)q.poll();
            if(right >= p2.l && right < p2.r)
                right = p2.r;
            else
            if(right < p2.l)
            {
                length += right - left;
                left = p2.l;
                right = p2.r;
            }
        }

        System.out.println((length + right) - left);
    }
}
