// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2261.java

import java.io.*;
import java.util.*;

public class p2261
{
    static class Point
        implements Comparable
    {

        public int compareTo(Point o)
        {
            int r = x - o.x;
            if(r == 0)
                r = y - o.y;
            return r;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Point)obj);
        }

        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    static class PointComparator
        implements Comparator
    {

        public int compare(Point o1, Point o2)
        {
            return o1.y - o2.y;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Point)obj, (Point)obj1);
        }

        PointComparator()
        {
        }
    }


    public p2261()
    {
    }

    static int dist(Point p1, Point p2)
    {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    static int bruteForce(List a, int x, int y)
    {
        int ans = -1;
        for(int i = x; i <= y - 1; i++)
        {
            for(int j = i + 1; j <= y; j++)
            {
                int k = dist((Point)a.get(i), (Point)a.get(j));
                if(ans == -1 || ans > k)
                    ans = k;
            }

        }

        return ans;
    }

    static int closest(List a, int x, int y)
    {
        int n = (y - x) + 1;
        if(n <= 3)
            return bruteForce(a, x, y);
        int mid = (x + y) / 2;
        int left = closest(a, x, mid);
        int right = closest(a, mid + 1, y);
        int ans = Math.min(left, right);
        List b = new ArrayList();
        for(int i = x; i <= y; i++)
        {
            int d = ((Point)a.get(i)).x - ((Point)a.get(mid)).x;
            if(d * d < ans)
                b.add((Point)a.get(i));
        }

        Collections.sort(b, new PointComparator());
        int m = b.size();
        for(int i = 0; i < m - 1; i++)
        {
            for(int j = i + 1; j < m; j++)
            {
                int k = ((Point)b.get(j)).y - ((Point)b.get(i)).y;
                if(k * k >= ans)
                    break;
                int d = dist((Point)b.get(i), (Point)b.get(j));
                if(d < ans)
                    ans = d;
            }

        }

        return ans;
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List a = new ArrayList();
        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            a.add(new Point(x, y));
        }

        Collections.sort(a);
        System.out.println(closest(a, 0, n - 1));
    }
}
