// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1987.java

import java.io.*;
import java.util.StringTokenizer;

public class p1987
{

    public p1987()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        for(int i = 0; i < r; i++)
        {
            String str = br.readLine();
            for(int j = 0; j < c; j++)
                arr[i][j] = str.charAt(j);

        }

        int x = arr[0][0] - 65;
        visited[x] = true;
        DFS(0, 0, 1);
        System.out.println(max);
    }

    public static void DFS(int x, int y, int count)
    {
        for(int i = 0; i < 4; i++)
        {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextY >= 0 && nextX < r && nextY < c)
            {
                int num = arr[nextX][nextY] - 65;
                if(!visited[num])
                {
                    visited[num] = true;
                    DFS(nextX, nextY, count + 1);
                    visited[num] = false;
                }
            }
        }

        if(count > max)
            max = count;
    }

    static char arr[][];
    static boolean visited[] = new boolean[26];
    static int dx[] = {
        -1, 0, 1, 0
    };
    static int dy[] = {
        0, -1, 0, 1
    };
    static int r;
    static int c;
    static int max = -1;

}
