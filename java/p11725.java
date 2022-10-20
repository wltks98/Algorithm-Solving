// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11725.java

import java.io.PrintStream;
import java.util.*;

public class p11725
{

    public p11725()
    {
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        list = new ArrayList[n + 1];
        parents = new int[n + 1];
        check = new boolean[n + 1];
        for(int i = 1; i < list.length; i++)
            list[i] = new ArrayList();

        for(int i = 1; i < n; i++)
        {
            int a = input.nextInt();
            int b = input.nextInt();
            list[a].add(Integer.valueOf(b));
            list[b].add(Integer.valueOf(a));
        }

        for(int data = 1; data < list.length; data++)
            if(!check[data])
                dfs(data);

        for(int i = 2; i < parents.length; i++)
            System.out.println(parents[i]);

        input.close();
    }

    public static void dfs(int flag)
    {
        if(!check[flag])
        {
            check[flag] = true;
            for(Iterator iterator = list[flag].iterator(); iterator.hasNext();)
            {
                int node = ((Integer)iterator.next()).intValue();
                if(!check[node])
                {
                    parents[node] = flag;
                    dfs(node);
                }
            }

        }
    }

    static List list[];
    static int parents[];
    static boolean check[];
}
