// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1992.java

import java.io.*;
import java.util.Scanner;

public class p1992
{

    public p1992()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            String str[] = br.readLine().split("");
            for(int j = 0; j < n; j++)
                a[i][j] = Integer.parseInt(str[j]);

        }

        sb.append("(");
        div(0, 0, n);
        sb.append(")");
        System.out.println(sb);
    }

    public static void div(int x, int y, int n)
    {
        int t = 1;
        int k = a[y][x];
        for(int i = y; i < y + n; i++)
        {
            if(t == 0)
                break;
            for(int j = x; j < x + n; j++)
            {
                if(a[i][j] == k)
                    continue;
                t = 0;
                break;
            }

        }

        if(t == 1)
            sb.append(k);
        else
        if(t == 0)
        {
            div(x, y, n / 2);
            div(x + n / 2, y, n / 2);
            div(x, y + n / 2, n / 2);
            div(x + n / 2, y + n / 2, n / 2);
        }
    }

    private static int a[][];
    private static StringBuilder sb = new StringBuilder();
    static BufferedReader br;

    static 
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
}
