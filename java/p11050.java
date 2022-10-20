// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11050.java

import java.io.PrintStream;
import java.util.Scanner;

public class p11050
{

    public p11050()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nf = 1;
        int kf = 1;
        for(int i = (n - k) + 1; i <= n; i++)
            nf *= i;

        if(k == 0)
        {
            kf = 1;
        } else
        {
            for(int i = 1; i <= k; i++)
                kf *= i;

        }
        System.out.println(nf / kf);
    }
}
