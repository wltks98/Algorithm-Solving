// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2239.java

import java.io.*;

public class p2239
{

    public p2239()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        for(int i = 0; i < 9; i++)
        {
            char input[] = br.readLine().toCharArray();
            for(int j = 0; j < 9; j++)
            {
                int value = input[j] - 48;
                map[i][j] = value;
                if(value != 0)
                {
                    rows[i][value] = true;
                    cols[j][value] = true;
                    squares[getSquares(i, j)][value] = true;
                }
            }

        }

        fillMap(0, 0);
        bw.flush();
        bw.close();
    }

    private static boolean fillMap(int x, int y)
        throws Exception
    {
        int nx = x;
        int ny = y + 1;
        if(ny == 9)
        {
            ny = 0;
            nx = x + 1;
        }
        if(x == 9)
        {
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                    bw.append((new StringBuilder(String.valueOf(map[i][j]))).toString());

                if(i < 8)
                    bw.append("\n");
            }

            return true;
        }
        if(map[x][y] != 0)
            return fillMap(nx, ny);
        for(int i = 1; i <= 9; i++)
        {
            int s = getSquares(x, y);
            if(!rows[x][i] && !cols[y][i] && !squares[s][i])
            {
                rows[x][i] = true;
                cols[y][i] = true;
                squares[getSquares(x, y)][i] = true;
                map[x][y] = i;
                boolean flag = fillMap(nx, ny);
                if(flag)
                    return true;
                rows[x][i] = false;
                cols[y][i] = false;
                squares[s][i] = false;
                map[x][y] = 0;
            }
        }

        return false;
    }

    private static int getSquares(int i, int j)
    {
        if(i < 3)
        {
            if(j < 3)
                return 0;
            return j >= 6 ? 2 : 1;
        }
        if(i < 6)
        {
            if(j < 3)
                return 3;
            return j >= 6 ? 5 : 4;
        }
        if(j < 3)
            return 6;
        return j >= 6 ? 8 : 7;
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static int map[][] = new int[9][9];
    static boolean rows[][] = new boolean[9][10];
    static boolean cols[][] = new boolean[9][10];
    static boolean squares[][] = new boolean[9][10];

    static 
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
