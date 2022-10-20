// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2798.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2798
{

    public p2798()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        int t[] = new int[n];
        for(int i = 0; i < n; i++)
            t[i] = sc.nextInt();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < n; k++)
                    if(i != j && j != k && i != k)
                    {
                        sum = t[i] + t[j] + t[k];
                        if(max < sum && sum <= m)
                            max = sum;
                    }

            }

        }

        System.out.println(max);
    }

    static int max = 0x80000000;

}
