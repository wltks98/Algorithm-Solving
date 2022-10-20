// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p9461.java

import java.io.PrintStream;
import java.util.Scanner;

public class p9461
{

    public p9461()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long arr[] = new long[101];
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;
        arr[4] = 2L;
        arr[5] = 2L;
        arr[6] = 3L;
        for(int i = 7; i < arr.length; i++)
            arr[i] = arr[i - 1] + arr[i - 5];

        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
            System.out.println(arr[sc.nextInt()]);

    }
}
