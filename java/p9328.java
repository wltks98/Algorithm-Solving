// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p9328.java

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p9328
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


    public p9328()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++)
        {
            String inputMap[] = br.readLine().split(" ");
            h = Integer.parseInt(inputMap[0]);
            w = Integer.parseInt(inputMap[1]);
            map = new char[h + 2][w + 2];
            visited = new boolean[h + 2][w + 2];
            key = new boolean[26];
            key = new boolean[26];
            count = 0;
            for(int i = 0; i < h + 2; i++)
            {
                for(int j = 0; j < w + 2; j++)
                    map[i][j] = '.';

            }

            for(int i = 1; i <= h; i++)
            {
                String input = br.readLine();
                for(int j = 1; j <= w; j++)
                    map[i][j] = input.charAt(j - 1);

            }

            String keyInput = br.readLine();
            if(!keyInput.equals("0"))
            {
                for(int i = 0; i < keyInput.length(); i++)
                {
                    int temp = keyInput.charAt(i) - 97;
                    key[temp] = true;
                }

            }
            BFS(0, 0);
            System.out.println(count);
        }

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
                if(nextX < 0 || nextY < 0 || nextX >= h + 2 || nextY >= w + 2 || visited[nextX][nextY] || map[nextX][nextY] == '*')
                    continue;
                if(map[nextX][nextY] == '$')
                {
                    count++;
                    map[nextX][nextY] = '.';
                } else
                if(map[nextX][nextY] >= 'a' && map[nextX][nextY] <= 'z')
                {
                    key[map[nextX][nextY] - 97] = true;
                    map[nextX][nextY] = '.';
                    visited = new boolean[h + 2][w + 2];
                } else
                if(map[nextX][nextY] >= 'A' && map[nextX][nextY] <= 'Z')
                {
                    if(!key[map[nextX][nextY] - 65])
                        continue;
                    map[nextX][nextY] = '.';
                }
                q.add(new Dot(nextX, nextY));
                visited[nextX][nextY] = true;
            }

        }
    }

    static int h;
    static int w;
    static int count;
    static char map[][];
    static boolean visited[][];
    static boolean key[];
    static int dx[] = {
        -1, 0, 1, 0
    };
    static int dy[] = {
        0, -1, 0, 1
    };

}
