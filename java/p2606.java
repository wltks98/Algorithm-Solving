// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2606.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2606
{

    public p2606()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        for(int i = 0; i < m; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = map[y][x] = 1;
        }

        dfs(1);
        int count = 0;
        for(int i = 2; i < n + 1; i++)
            if(visit[i])
                count++;

        System.out.println(count);
    }

    private static void dfs(int index)
    {
        for(int i = 1; i < n + 1; i++)
            if(!visit[i] && map[index][i] == 1)
            {
                visit[i] = true;
                dfs(i);
            }

    }

    private static int n;
    private static int m;
    private static int map[][];
    private static boolean visit[];
}
