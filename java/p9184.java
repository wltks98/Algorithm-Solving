// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p9184.java

import java.io.PrintStream;
import java.util.Scanner;

public class p9184
{

    public p9184()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n[][][] = new int[21][21][21];
        for(int i = 0; i <= 20; i++)
        {
            for(int j = 0; j <= 20; j++)
            {
                for(int k = 0; k <= 20; k++)
                    if(i == 0 || j == 0 || k == 0)
                        n[i][j][k] = 1;
                    else
                    if(i < j && j < k)
                        n[i][j][k] = (n[i][j][k - 1] + n[i][j - 1][k - 1]) - n[i][j - 1][k];
                    else
                        n[i][j][k] = (n[i - 1][j][k] + n[i - 1][j - 1][k] + n[i - 1][j][k - 1]) - n[i - 1][j - 1][k - 1];

            }

        }

        do
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a != -1 || b != -1 || c != -1)
                sb.append((new StringBuilder("w(")).append(a).append(", ").append(b).append(", ").append(c).append(") = ").toString());
            if(a != -1 || b != -1 || c != -1)
            {
                if(a <= 0 || b <= 0 || c <= 0)
                {
                    a = 0;
                    b = 0;
                    c = 0;
                } else
                if(a > 20 || b > 20 || c > 20)
                {
                    a = 20;
                    b = 20;
                    c = 20;
                }
                sb.append((new StringBuilder(String.valueOf(n[a][b][c]))).append("\n").toString());
            } else
            {
                System.out.println(sb);
                return;
            }
        } while(true);
    }
}
