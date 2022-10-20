// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1012.java

import java.io.*;
import java.util.Scanner;

public class p1012
{

    public p1012()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int p = 0; p < t; p++)
        {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            house = new int[n][m];
            visited = new int[n][m];
            for(int i = 0; i < k; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                house[b][a] = 1;
                visited[b][a] = 0;
            }

            count = 0;
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                    if(house[i][j] == 1 && visited[i][j] == 0)
                    {
                        visited[i][j] = 1;
                        count++;
                        dfs(i, j);
                    }

            }

            System.out.println(count);
        }

    }

    private static void dfs(int y, int x)
    {
        if(x - 1 >= 0 && house[y][x - 1] == 1 && visited[y][x - 1] == 0)
        {
            visited[y][x - 1] = 1;
            dfs(y, x - 1);
        }
        if(x + 1 < m && house[y][x + 1] == 1 && visited[y][x + 1] == 0)
        {
            visited[y][x + 1] = 1;
            dfs(y, x + 1);
        }
        if(y - 1 >= 0 && house[y - 1][x] == 1 && visited[y - 1][x] == 0)
        {
            visited[y - 1][x] = 1;
            dfs(y - 1, x);
        }
        if(y + 1 < n && house[y + 1][x] == 1 && visited[y + 1][x] == 0)
        {
            visited[y + 1][x] = 1;
            dfs(y + 1, x);
        }
    }

    private static int m;
    private static int n;
    private static int k;
    private static int count;
    private static int check[][];
    private static int house[][];
    private static int visited[][];
    static BufferedReader br;

    static 
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
}
