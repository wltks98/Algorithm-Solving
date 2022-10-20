// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p7576.java

import java.io.PrintStream;
import java.util.*;

public class p7576
{
    static class Point
    {

        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }


    public p7576()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N + 2][M + 2];
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= M; j++)
            {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1)
                    queue.offer(new Point(i, j));
            }

        }

        for(int i = 0; i < N + 2; i++)
        {
            map[i][0] = -1;
            map[i][M + 1] = -1;
        }

        for(int i = 0; i < M + 2; i++)
        {
            map[0][i] = -1;
            map[N + 1][i] = -1;
        }

        bfs();
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= M; j++)
                if(map[i][j] == 0)
                {
                    System.out.println(-1);
                    return;
                }

        }

        if(resultTreeSet.isEmpty())
            System.out.println(0);
        else
            System.out.println(((Integer)resultTreeSet.pollLast()).intValue() - 1);
    }

    static void bfs()
    {
        while(!queue.isEmpty()) 
        {
            Point point = (Point)queue.poll();
            for(int i = 0; i < 4; i++)
            {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];
                if(map[x2][y2] == 0)
                {
                    map[x2][y2] = map[point.x][point.y] + 1;
                    resultTreeSet.add(Integer.valueOf(map[x2][y2]));
                    queue.offer(new Point(x2, y2));
                }
            }

        }
    }

    private static int N;
    private static int M;
    private static int map[][];
    private static int dx[] = {
        -1, 0, 1, 0
    };
    private static int dy[] = {
        0, -1, 0, 1
    };
    private static TreeSet resultTreeSet = new TreeSet();
    private static Queue queue = new LinkedList();

}
