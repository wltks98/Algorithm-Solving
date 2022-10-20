// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2580.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2580
{

    public p2580()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int stok[][] = new int[9][9];
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
                stok[i][j] = sc.nextInt();

        }

        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
                if(stok[i][j] == 0)
                {
                    for(int k = 1; k < 10; k++)
                    {
                        if(!isp(i, j, k, stok))
                            continue;
                        stok[i][j] = k;
                        break;
                    }

                }

        }

        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
                System.out.print((new StringBuilder(String.valueOf(stok[i][j]))).append(" ").toString());

            if(i == 8)
                break;
            System.out.println("");
        }

    }

    static boolean isp(int row, int cal, int k, int stok[][])
    {
        for(int i = 0; i < row; i++)
            if(k == stok[i][cal])
                return false;

        for(int j = 0; j < cal; j++)
            if(k == stok[row][j])
                return false;

        int r3 = (row / 3) * 3;
        int c3 = (cal / 3) * 3;
        for(int a = 0; a < 3; a++)
        {
            for(int b = 0; b < 3; b++)
                if(k == stok[r3 + a][c3 + b])
                    return false;

        }

        return true;
    }
}
