// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2805.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2805
{

    public p2805()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        long a[] = new long[n];
        long max = 0L;
        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextLong();
            max = Math.max(max, a[i]);
        }

        long left = 0L;
        long right = max;
        long sum = 0L;
        long height_max = 0L;
        while(left <= right) 
        {
            long mid = (left + right) / 2L;
            sum = 0L;
            for(int i = 0; i < n; i++)
                if(a[i] - mid > 0L)
                    sum += a[i] - mid;

            if(sum >= m)
            {
                left = mid + 1L;
                height_max = Math.max(height_max, mid);
            } else
            {
                right = mid - 1L;
            }
        }
        System.out.println(height_max);
    }
}
