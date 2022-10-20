// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1654.java

import java.io.PrintStream;
import java.util.Scanner;

class p1654
{

    p1654()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        long N = sc.nextLong();
        long arr[] = new long[K];
        long max = 0L;
        for(int i = 0; i < K; i++)
        {
            arr[i] = sc.nextLong();
            max = Math.max(max, arr[i]);
        }

        long left = 1L;
        long right;
        for(right = max; left <= right;)
        {
            long mid = (left + right) / 2L;
            long sum = 0L;
            for(int i = 0; i < K; i++)
                sum += arr[i] / mid;

            if(sum >= N)
                left = mid + 1L;
            else
                right = mid - 1L;
        }

        System.out.println(right);
    }
}
