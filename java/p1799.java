// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1799.java

import java.io.*;
import java.util.StringTokenizer;

public class p1799
{

    public p1799()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        colors = new boolean[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                colors[i][j] = i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0;
            }

        }

        solve(-1, true, 0);
        solve(-1, false, 0);
        System.out.println(res[0] + res[1]);
    }

    static void solve(int index, boolean black, int cnt)
    {
        for(int i = index + 1; i < n * n; i++)
        {
            int x = i / n;
            int y = i % n;
            if(colors[x][y] == black && map[x][y] != 0 && check(x, y))
            {
                visited[x][y] = true;
                solve(i, black, cnt + 1);
                visited[x][y] = false;
            }
        }

        res[black ? 1 : 0] = Math.max(res[black ? 1 : 0], cnt);
    }

    static boolean check(int x, int y)
    {
        for(int i = 0; i < 2; i++)
        {
            int nx = x;
            for(int ny = y; nx >= 0 && nx < n && ny >= 0 && ny < n; ny += dy[i])
            {
                if(visited[nx][ny])
                    return false;
                nx += dx[i];
            }

        }

        return true;
    }

    static int n;
    static int map[][];
    static boolean colors[][];
    static boolean visited[][];
    static int res[] = new int[2];
    static int dx[] = {
        -1, -1
    };
    static int dy[] = {
        1, -1
    };

}
