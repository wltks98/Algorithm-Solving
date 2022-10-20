// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11444.java

import java.io.PrintStream;
import java.util.Scanner;

public class p11444
{

    public p11444()
    {
    }

    public static void main(String args[])
    {
        long arr[][] = {
            {
                1L, 1L
            }, {
                1L, 0
            }
        };
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong();
        arr = mat_pow(arr, N);
        System.out.println(arr[0][1]);
    }

    public static long[][] multiply(long arr1[][], long arr2[][])
    {
        long result[][] = new long[2][2];
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                long sum = 0L;
                for(int k = 0; k < 2; k++)
                {
                    sum += (arr1[i][k] * arr2[k][j]) % (long)mod;
                    sum %= mod;
                }

                result[i][j] = sum % (long)mod;
            }

        }

        return result;
    }

    public static long[][] mat_pow(long arr[][], long num)
    {
        if(num == 1L)
        {
            for(int i = 0; i < 2; i++)
            {
                for(int j = 0; j < 2; j++)
                    arr[i][j] %= mod;

            }

            return arr;
        }
        long result[][] = mat_pow(arr, num / 2L);
        if(num % 2L == 1L)
            return multiply(multiply(result, result), arr);
        else
            return multiply(result, result);
    }

    static int mod = 0x3b9aca07;

}
