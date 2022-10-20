// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1717.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1717
{

    public p1717()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++)
            parent[i] = i;

        for(int i = 0; i < m; i++)
        {
            int flag = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(flag == 0)
                union(a, b);
            else
            if(isSameParent(a, b))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

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

    private static int parent[];
}
