// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1904.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1904
{

    public p1904()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= n; i++)
            if(i % 2 == 1)
                arr[i] = arr[i - 1] * arr[i - 2];

        System.out.println(arr[n]);
    }
}
