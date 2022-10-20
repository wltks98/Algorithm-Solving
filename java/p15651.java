// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p15651.java

import java.io.PrintStream;
import java.util.Scanner;

public class p15651
{

    public p15651()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        arr = new int[M];
        dfs(N, M, 0);
    }

    public static void dfs(int N, int M, int depth)
    {
        if(depth == M)
        {
            int ai[];
            int k = (ai = arr).length;
            for(int j = 0; j < k; j++)
            {
                int val = ai[j];
                System.out.print((new StringBuilder(String.valueOf(val))).append(" ").toString());
            }

            System.out.println();
            return;
        }
        for(int i = 0; i < N; i++)
        {
            arr[depth] = i + 1;
            dfs(N, M, depth + 1);
        }

    }

    public static int arr[];
}
