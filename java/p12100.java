// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p12100.java

import java.io.*;
import java.util.StringTokenizer;

public class p12100
{

    public p12100()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        map = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(stz.nextToken());

        }

        game(0);
        System.out.println(answer);
    }

    public static void game(int count)
    {
        if(count == 5)
        {
            findMax();
            return;
        }
        int copy[][] = new int[n][n];
        for(int i = 0; i < n; i++)
            copy[i] = (int[])map[i].clone();

        for(int i = 0; i < 4; i++)
        {
            move(i);
            game(count + 1);
            for(int a = 0; a < n; a++)
                map[a] = (int[])copy[a].clone();

        }

    }

    public static void move(int dir)
    {
        switch(dir)
        {
        default:
            break;

        case 0: // '\0'
            for(int i = 0; i < n; i++)
            {
                int index = 0;
                int block = 0;
                for(int j = 0; j < n; j++)
                    if(map[j][i] != 0)
                        if(block == map[j][i])
                        {
                            map[index - 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        } else
                        {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index++;
                        }

            }

            break;

        case 1: // '\001'
            for(int i = 0; i < n; i++)
            {
                int index = n - 1;
                int block = 0;
                for(int j = n - 1; j >= 0; j--)
                    if(map[j][i] != 0)
                        if(block == map[j][i])
                        {
                            map[index + 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        } else
                        {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index--;
                        }

            }

            break;

        case 2: // '\002'
            for(int i = 0; i < n; i++)
            {
                int index = 0;
                int block = 0;
                for(int j = 0; j < n; j++)
                    if(map[i][j] != 0)
                        if(block == map[i][j])
                        {
                            map[i][index - 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        } else
                        {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index++;
                        }

            }

            break;

        case 3: // '\003'
            for(int i = 0; i < n; i++)
            {
                int index = n - 1;
                int block = 0;
                for(int j = n - 1; j >= 0; j--)
                    if(map[i][j] != 0)
                        if(block == map[i][j])
                        {
                            map[i][index + 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        } else
                        {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index--;
                        }

            }

            break;
        }
    }

    public static void findMax()
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                answer = Math.max(answer, map[i][j]);

        }

    }

    static int n;
    static int answer;
    static int map[][];
}
