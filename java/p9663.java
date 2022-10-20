// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p9663.java

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class p9663
{

    public p9663()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int chess[] = new int[N];
        bfs(N, chess, 0);
        System.out.println(ans);
    }

    static void bfs(int N, int chess[], int row)
    {
        if(row == N)
        {
            ans++;
        } else
        {
            for(int i = 0; i < N; i++)
            {
                chess[row] = i;
                if(isPossible(row, chess))
                    bfs(N, chess, row + 1);
            }

        }
    }

    static boolean isPossible(int row, int chess[])
    {
        for(int i = 0; i < row; i++)
        {
            if(chess[i] == chess[row])
                return false;
            if(Math.abs(chess[i] - chess[row]) == Math.abs(i - row))
                return false;
        }

        return true;
    }

    static int ans;
}
