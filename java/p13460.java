// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p13460.java

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p13460
{
    static class Pos
    {

        int n;
        int m;
        int move;

        Pos(int n, int m, int move)
        {
            this.n = n;
            this.m = m;
            this.move = move;
        }
    }


    public p13460()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        board = new char[N][M];
        Pos redPos = null;
        Pos bluePos = null;
        for(int i = 0; i < N; i++)
        {
            String str = br.readLine();
            for(int j = 0; j < M; j++)
            {
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'R')
                    redPos = new Pos(i, j, 0);
                if(board[i][j] == 'B')
                    bluePos = new Pos(i, j, 0);
            }

        }

        int res = bfs(redPos, bluePos);
        bw.write((new StringBuilder(String.valueOf(res))).append("\n").toString());
        bw.flush();
    }

    public static int bfs(Pos red, Pos blue)
    {
        Queue redque = new LinkedList();
        Queue blueque = new LinkedList();
        boolean redflag = false;
        boolean blueflag = false;
        int r[] = {
            1, 0, -1, 0
        };
        int c[] = {
            0, 1, 0, -1
        };
        redque.add(red);
        blueque.add(blue);
        while(!redque.isEmpty() && !blueque.isEmpty()) 
        {
            Pos p1 = (Pos)redque.poll();
            Pos p2 = (Pos)blueque.poll();
            if(p1.move >= 10)
                break;
            for(int i = 0; i < 4; i++)
            {
                Pos redPos = new Pos(p1.n, p1.m, p1.move + 1);
                Pos bluePos = new Pos(p2.n, p2.m, p2.move + 1);
                board[redPos.n][redPos.m] = 'R';
                board[bluePos.n][bluePos.m] = 'B';
                redflag = false;
                blueflag = false;
                do
                {
                    if(board[redPos.n + r[i]][redPos.m + c[i]] == 'O')
                    {
                        redflag = true;
                        board[redPos.n][redPos.m] = '.';
                        redPos.n = redPos.n + r[i];
                        redPos.m = redPos.m + c[i];
                    }
                    if(board[bluePos.n + r[i]][bluePos.m + c[i]] == 'O')
                    {
                        blueflag = true;
                        break;
                    }
                    if((board[redPos.n + r[i]][redPos.m + c[i]] != '.' || redflag) && board[bluePos.n + r[i]][bluePos.m + c[i]] != '.')
                        break;
                    if(board[redPos.n + r[i]][redPos.m + c[i]] == '.' && !redflag)
                    {
                        board[redPos.n][redPos.m] = '.';
                        redPos.n = redPos.n + r[i];
                        redPos.m = redPos.m + c[i];
                        board[redPos.n][redPos.m] = 'R';
                    }
                    if(board[bluePos.n + r[i]][bluePos.m + c[i]] == '.')
                    {
                        board[bluePos.n][bluePos.m] = '.';
                        bluePos.n = bluePos.n + r[i];
                        bluePos.m = bluePos.m + c[i];
                        board[bluePos.n][bluePos.m] = 'B';
                    }
                } while(true);
                if(redflag && !blueflag)
                    return redPos.move;
                if(!blueflag)
                {
                    redque.add(redPos);
                    blueque.add(bluePos);
                }
                if(board[redPos.n][redPos.m] == 'R')
                    board[redPos.n][redPos.m] = '.';
                if(board[bluePos.n][bluePos.m] == 'B')
                    board[bluePos.n][bluePos.m] = '.';
            }

        }
        return -1;
    }

    private static char board[][];
    private static int N;
    private static int M;
}
