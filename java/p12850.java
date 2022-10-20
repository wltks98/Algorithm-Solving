// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p12850.java

import java.io.PrintStream;
import java.util.Scanner;

public class p12850
{

    public p12850()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        map = new long[8][8];
        map[0][1] = 1L;
        map[0][2] = 1L;
        map[1][0] = 1L;
        map[1][2] = 1L;
        map[1][3] = 1L;
        map[2][0] = 1L;
        map[2][1] = 1L;
        map[2][3] = 1L;
        map[2][5] = 1L;
        map[3][1] = 1L;
        map[3][2] = 1L;
        map[3][4] = 1L;
        map[3][5] = 1L;
        map[4][3] = 1L;
        map[4][5] = 1L;
        map[4][6] = 1L;
        map[5][2] = 1L;
        map[5][3] = 1L;
        map[5][4] = 1L;
        map[5][7] = 1L;
        map[6][4] = 1L;
        map[6][7] = 1L;
        map[7][5] = 1L;
        map[7][6] = 1L;
        long c[][] = new long[8][8];
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
                c[i][j] = map[i][j];

        }

        c = mypow(c, N);
        System.out.println(c[0][0]);
    }

    private static long[][] mult(long c1[][], long c2[][])
    {
        long res[][] = new long[8][8];
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                for(int k = 0; k < 8; k++)
                    res[i][j] = (res[i][j] + c1[i][k] * c2[k][j]) % (long)M;

            }

        }

        return res;
    }

    private static long[][] mypow(long c[][], long N)
    {
        if(N == 1L)
            return c;
        if(N % 2L == 1L)
        {
            long res[][] = new long[8][8];
            res = mult(c, c);
            return mult(c, mypow(res, N / 2L));
        } else
        {
            long res[][] = new long[8][8];
            res = mult(c, c);
            return mypow(res, N / 2L);
        }
    }

    static long map[][];
    static int M = 0x3b9aca07;

}
