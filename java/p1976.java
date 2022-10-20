// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1976.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1976
{

    public p1976()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean flag = true;
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++)
            parent[i] = i;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int a = sc.nextInt();
                if(a == 1)
                    union(i, j);
            }

        }

        int b = sc.nextInt() - 1;
        for(int i = 1; i < m; i++)
        {
            int c = sc.nextInt() - 1;
            if(!isSameParent(b, c))
            {
                flag = false;
                break;
            }
            b = c;
        }

        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
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
