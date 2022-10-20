// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2667.java

import java.io.*;
import java.util.Scanner;

public class p2667
{

    public p2667()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        house = new int[n][n];
        visited = new int[n][n];
        check = new int[n * n][1];
        for(int i = 0; i < n; i++)
        {
            String str[] = br.readLine().split("");
            for(int j = 0; j < n; j++)
            {
                house[i][j] = Integer.parseInt(str[j]);
                visited[i][j] = 0;
            }

        }

        count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                if(house[i][j] == 1 && visited[i][j] == 0)
                {
                    visited[i][j] = 1;
                    count++;
                    check[count][0] = 1;
                    dfs(i, j);
                }

        }

        System.out.println(count);
        for(int i = 0; i < count; i++)
            System.out.println(check[i + 1][0]);

    }

    private static void dfs(int y, int x)
    {
        if(x - 1 >= 0 && house[y][x - 1] == 1 && visited[y][x - 1] == 0)
        {
            check[count][0]++;
            visited[y][x - 1] = 1;
            dfs(y, x - 1);
        }
        if(x + 1 < n && house[y][x + 1] == 1 && visited[y][x + 1] == 0)
        {
            check[count][0]++;
            visited[y][x + 1] = 1;
            dfs(y, x + 1);
        }
        if(y - 1 >= 0 && house[y - 1][x] == 1 && visited[y - 1][x] == 0)
        {
            check[count][0]++;
            visited[y - 1][x] = 1;
            dfs(y - 1, x);
        }
        if(y + 1 < n && house[y + 1][x] == 1 && visited[y + 1][x] == 0)
        {
            check[count][0]++;
            visited[y + 1][x] = 1;
            dfs(y + 1, x);
        }
    }

    private static int n;
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
