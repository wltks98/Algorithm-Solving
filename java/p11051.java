// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11051.java

import java.io.*;

public class p11051
{

    public p11051()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s[] = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);
        int binomi[][] = new int[1001][1001];
        binomi[1][0] = binomi[1][1] = 1;
        for(int i = 2; i <= n; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                if(i == j || j == 0)
                    binomi[i][j] = 1;
                else
                    binomi[i][j] = binomi[i - 1][j - 1] + binomi[i - 1][j];
                binomi[i][j] %= mod;
            }

        }

        System.out.println(binomi[n][r]);
    }

    static int mod = 10007;

}
