// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2206.java

import java.io.PrintStream;
import java.util.*;

public class p2206
{
    static class Point
    {

        int x;
        int y;
        int wall;
        int cnt;

        public Point(int x, int y, int wall, int cnt)
        {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.cnt = cnt;
        }
    }


    public p2206()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        visited = new boolean[N][M][2];
        mat = new int[N][M];
        for(int i = 0; i < N; i++)
        {
            String str = scan.next();
            for(int j = 0; j < M; j++)
                mat[i][j] = Integer.parseInt((new StringBuilder(String.valueOf(str.charAt(j)))).toString());

        }

        bfs(0, 0);
    }

    public static void bfs(int x, int y)
    {
        int cnt = 1;
        int dx[] = {
            -1, 0, 0, 1
        };
        int dy[] = {
            0, -1, 1, 0
        };
        Queue que = new LinkedList();
        que.offer(new Point(x, y, 0, 1));
        visited[x][y][0] = true;
        visited[x][y][1] = true;
        while(!que.isEmpty()) 
        {
            Point p = (Point)que.poll();
            if(p.x == N - 1 && p.y == M - 1)
            {
                System.out.println(p.cnt);
                return;
            }
            for(int i = 0; i < 4; i++)
            {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int wall = p.wall;
                cnt = p.cnt;
                if(nx >= 0 && nx < N && ny >= 0 && ny < M)
                    if(mat[nx][ny] == 1 && wall == 0 && !visited[nx][ny][1])
                    {
                        visited[nx][ny][1] = true;
                        que.offer(new Point(nx, ny, 1, cnt + 1));
                    } else
                    if(mat[nx][ny] == 0 && !visited[nx][ny][wall])
                    {
                        visited[nx][ny][wall] = true;
                        que.offer(new Point(nx, ny, wall, cnt + 1));
                    }
            }

        }
        System.out.println("-1");
    }

    static int N;
    static int M;
    static int mat[][];
    static boolean visited[][][];
}
