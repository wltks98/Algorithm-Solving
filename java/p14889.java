// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p14889.java

import java.io.*;
import java.util.StringTokenizer;

public class p14889
{

    public p14889()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = N / 2;
        a = new int[N][N];
        for(int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++)
                a[i][j] = Integer.parseInt(st.nextToken());

        }

        b = new int[N / 2];
        select = new boolean[N];
        comb(N, R);
        System.out.println(min);
    }

    private static void comb(int n, int r)
    {
        if(min == 0)
            return;
        if(r == 0)
        {
            start_sum = 0;
            link_sum = 0;
            for(int i = 0; i < N; i++)
            {
                for(int j = i + 1; j < N; j++)
                    if(select[i] == select[j])
                        if(select[i])
                            start_sum += a[i][j] + a[j][i];
                        else
                            link_sum += a[i][j] + a[j][i];

            }

            min = Math.min(min, Math.abs(start_sum - link_sum));
            return;
        }
        if(n < r)
        {
            return;
        } else
        {
            b[r - 1] = n - 1;
            select[n - 1] = true;
            comb(n - 1, r - 1);
            select[n - 1] = false;
            comb(n - 1, r);
            return;
        }
    }

    private static int N;
    private static int R;
    private static int start_sum;
    private static int link_sum;
    private static int a[][];
    private static boolean select[];
    private static int min = 0x7fffffff;
    static int b[];

}
