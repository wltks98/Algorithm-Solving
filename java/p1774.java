// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1774.java

import java.io.PrintStream;
import java.util.*;

public class p1774
{
    private static class Space
        implements Comparable
    {

        public int compareTo(Space o)
        {
            return weight <= o.weight ? -1 : 1;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Space)obj);
        }

        int x;
        int y;
        double weight;

        public Space(int x, int y, double weight)
        {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }


    public p1774()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N];
        spaces = new Space[N];
        for(int i = 0; i < N; i++)
            parent[i] = i;

        for(int i = 0; i < N; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            spaces[i] = new Space(x, y, 0.0D);
        }

        for(int i = 0; i < M; i++)
        {
            int space1 = sc.nextInt();
            int space2 = sc.nextInt();
            union(space1 - 1, space2 - 1);
        }

        for(int i = 0; i < spaces.length - 1; i++)
        {
            Space space1 = spaces[i];
            for(int j = i + 1; j < spaces.length; j++)
            {
                Space space2 = spaces[j];
                double weight = Math.sqrt(Math.pow(space1.x - space2.x, 2D) + Math.pow(space1.y - space2.y, 2D));
                spaceList.add(new Space(i, j, weight));
            }

        }

        Collections.sort(spaceList);
        for(int i = 0; i < spaceList.size(); i++)
        {
            Space space = (Space)spaceList.get(i);
            if(!isSameParent(space.x, space.y))
            {
                answer += space.weight;
                union(space.x, space.y);
            }
        }

        System.out.println(String.format("%.2f", new Object[] {
            Double.valueOf(answer)
        }));
    }

    private static void union(int x, int y)
    {
        x = find(x);
        y = find(y);
        if(x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    private static boolean isSameParent(int x, int y)
    {
        return find(x) == find(y);
    }

    private static int find(int x)
    {
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    private static int parent[];
    private static Space spaces[];
    private static ArrayList spaceList = new ArrayList();
    private static double answer = 0.0D;

}
