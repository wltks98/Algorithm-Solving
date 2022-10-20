// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p7562.java

import java.io.PrintStream;
import java.util.*;

public class p7562
{
    static class Dot
    {

        int x;
        int y;

        Dot(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }


    public p7562()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int k = 0; k < T; k++)
        {
            N = sc.nextInt();
            arr = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                    visited[i][j] = false;

            }

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            visited[x1][y1] = true;
            BFS(x1, y1);
            System.out.println(arr[x2][y2]);
        }

    }

    public static void BFS(int x, int y)
    {
        Queue q = new LinkedList();
        q.add(new Dot(x, y));
        while(!q.isEmpty()) 
        {
            Dot d = (Dot)q.poll();
            for(int i = 0; i < 8; i++)
            {
                int nextX = d.x + dx[i];
                int nextY = d.y + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY])
                {
                    q.add(new Dot(nextX, nextY));
                    arr[nextX][nextY] = arr[d.x][d.y] + 1;
                    visited[nextX][nextY] = true;
                }
            }

        }
    }

    static int arr[][];
    static boolean visited[][];
    static int dx[] = {
        2, 2, 1, -1, -2, -2, 1, -1
    };
    static int dy[] = {
        1, -1, -2, -2, 1, -1, 2, 2
    };
    static int N;

}
