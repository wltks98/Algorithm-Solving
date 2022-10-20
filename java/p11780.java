// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11780.java

import java.io.*;
import java.util.Stack;

public class p11780
{

    public p11780()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        path = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                path[i][j] = INF;
                if(i != j)
                    map[i][j] = INF;
            }

        }

        for(int i = 0; i < M; i++)
        {
            String input[] = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            map[start][end] = Math.min(map[start][end], cost);
            path[start][end] = start;
        }

        floydWarshall();
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
                if(map[i][j] == INF)
                    System.out.print("0 ");
                else
                    System.out.print((new StringBuilder(String.valueOf(map[i][j]))).append(" ").toString());

            System.out.println();
        }

        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
                if(path[i][j] == INF)
                {
                    System.out.println(0);
                } else
                {
                    int pre = j;
                    stack.push(Integer.valueOf(j));
                    while(i != path[i][pre]) 
                    {
                        pre = path[i][pre];
                        stack.push(Integer.valueOf(pre));
                    }
                    System.out.print((new StringBuilder(String.valueOf(stack.size() + 1))).append(" ").toString());
                    System.out.print((new StringBuilder(String.valueOf(i))).append(" ").toString());
                    for(; !stack.empty(); System.out.print((new StringBuilder()).append(stack.pop()).append(" ").toString()));
                    System.out.println();
                }

        }

    }

    public static void floydWarshall()
    {
        for(int k = 1; k <= N; k++)
        {
            for(int i = 1; i <= N; i++)
            {
                for(int j = 1; j <= N; j++)
                    if(map[i][j] > map[i][k] + map[k][j])
                    {
                        map[i][j] = map[i][k] + map[k][j];
                        path[i][j] = path[k][j];
                    }

            }

        }

    }

    static int map[][];
    static int path[][];
    static int N;
    static int INF = 0x989681;

}
