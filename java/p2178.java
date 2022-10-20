// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2178.java

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.*;

public class p2178
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


    public p2178()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++)
        {
            String str = sc.nextLine();
            for(int j = 0; j < M; j++)
            {
                arr[i][j] = str.charAt(j) - 48;
                visited[i][j] = false;
            }

        }

        visited[0][0] = true;
        BFS(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }

    public static void BFS(int x, int y)
    {
        Queue q = new LinkedList();
        q.add(new Dot(x, y));
        while(!q.isEmpty()) 
        {
            Dot d = (Dot)q.poll();
            for(int i = 0; i < 4; i++)
            {
                int nextX = d.x + dx[i];
                int nextY = d.y + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && !visited[nextX][nextY] && arr[nextX][nextY] != 0)
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
        -1, 0, 1, 0
    };
    static int dy[] = {
        0, -1, 0, 1
    };
    static int N;
    static int M;

}
