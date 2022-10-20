// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2467.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2467
{

    public p2467()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int start = 0;
        int end = n - 1;
        int sum = 0;
        int min = 0x7fffffff;
        int x = 0;
        int y = 0;
        while(start < end) 
        {
            sum = a[start] + a[end];
            if(min > Math.abs(sum))
            {
                min = Math.abs(sum);
                x = a[start];
                y = a[end];
            }
            if(sum < 0)
            {
                start++;
                continue;
            }
            if(sum <= 0)
                break;
            end--;
        }
        System.out.println((new StringBuilder(String.valueOf(x))).append(" ").append(y).toString());
    }
}
