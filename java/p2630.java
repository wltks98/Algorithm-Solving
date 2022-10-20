// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2630.java

import java.io.*;
import java.util.StringTokenizer;

public class p2630
{

    public p2630()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for(int row = 0; row < N; row++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int col = 0; col < N; col++)
                matrix[row][col] = Integer.parseInt(st.nextToken());

        }

        solve(0, 0, N);
        System.out.println((new StringBuilder(String.valueOf(whiteNum))).append("\n").append(blueNum).toString());
        br.close();
    }

    private static void solve(int startX, int startY, int length)
    {
        if(length == 1)
        {
            if(matrix[startX][startY] == 1)
                blueNum++;
            else
                whiteNum++;
            return;
        }
        boolean isSameColor = true;
        int currentColor = matrix[startX][startY];
        for(int i = 0; i < length; i++)
        {
            for(int j = 0; j < length; j++)
            {
                if(currentColor == matrix[startX + i][startY + j])
                    continue;
                isSameColor = false;
                break;
            }

        }

        if(isSameColor)
        {
            if(currentColor == 0)
                whiteNum++;
            else
                blueNum++;
            return;
        } else
        {
            solve(startX, startY, length / 2);
            solve(startX, startY + length / 2, length / 2);
            solve(startX + length / 2, startY, length / 2);
            solve(startX + length / 2, startY + length / 2, length / 2);
            return;
        }
    }

    private static int whiteNum = 0;
    private static int blueNum = 0;
    private static int matrix[][];

}
