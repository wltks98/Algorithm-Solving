// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p9372.java

import java.io.PrintStream;
import java.util.Scanner;

public class p9372
{

    public p9372()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int t = sc.nextInt();
        for(int j = 0; j < t; j++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for(int i = 0; i < m; i++)
            {
                int a = sc.nextInt();
                int k = sc.nextInt();
            }

            sb.append((new StringBuilder(String.valueOf(n - 1))).append("\n").toString());
        }

        System.out.println(sb);
    }
}
