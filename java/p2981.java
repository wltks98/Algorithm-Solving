// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2981.java

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class p2981
{

    public p2981()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int arr[] = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = in.nextInt();

        Arrays.sort(arr);
        int gcdVal = arr[1] - arr[0];
        for(int i = 2; i < N; i++)
            gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);

        for(int i = 2; i <= gcdVal; i++)
            if(gcdVal % i == 0)
                System.out.print((new StringBuilder(String.valueOf(i))).append(" ").toString());

    }

    static int gcd(int a, int b)
    {
        int r;
        for(; b != 0; b = r)
        {
            r = a % b;
            a = b;
        }

        return a;
    }
}
