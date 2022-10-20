// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p4386.java

import java.io.PrintStream;
import java.util.*;

public class p4386
{
    static class Star
        implements Comparable
    {

        public int compareTo(Star o)
        {
            return Double.compare(weight, o.weight);
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Star)obj);
        }

        double x;
        double y;
        double weight;

        public Star(double x, double y, double weight)
        {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }


    public p4386()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            tmpList.add(new Star(x, y, 0.0D));
        }

        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;

        for(int i = 0; i < tmpList.size() - 1; i++)
        {
            Star star1 = (Star)tmpList.get(i);
            double x1 = star1.x;
            double y1 = star1.y;
            for(int j = i + 1; j < tmpList.size(); j++)
            {
                Star star2 = (Star)tmpList.get(j);
                double x2 = star2.x;
                double y2 = star2.y;
                double weight = Math.sqrt(Math.pow(x1 - x2, 2D) + Math.pow(y1 - y2, 2D));
                starList.add(new Star(i, j, weight));
            }

        }

        Collections.sort(starList);
        for(int i = 0; i < starList.size(); i++)
        {
            Star star = (Star)starList.get(i);
            if(!isSameParent((int)star.x, (int)star.y))
            {
                answer = (float)((double)answer + star.weight);
                union((int)star.x, (int)star.y);
            }
        }

        System.out.println((double)Math.round(answer * 100F) / 100D);
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
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    private static boolean isSameParent(int x, int y)
    {
        x = find(x);
        y = find(y);
        return x == y;
    }

    private static int parent[];
    private static ArrayList tmpList = new ArrayList();
    private static ArrayList starList = new ArrayList();
    private static float answer = 0.0F;

}
