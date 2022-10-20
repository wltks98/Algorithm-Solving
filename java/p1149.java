// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1149.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1149
{

    public p1149()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int color[][] = new int[n][3];
        int min = 0x7fffffff;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 3; j++)
                color[i][j] = sc.nextInt();

        }

        int arr[] = new int[n + 1];
        for(int c = 0; c < 3; c++)
        {
            for(int i = 0; i < n; i++)
            {
                int d = c;
                if(i == 0)
                    arr[i] = c;
                else
                if(i == 1)
                    do
                    {
                        if(d > 3)
                            d -= 4;
                        arr[i] = d;
                        d++;
                    } while(arr[i] == arr[i - 1]);
                else
                if(i == n)
                    do
                    {
                        if(d > 3)
                            d -= 4;
                        arr[i] = d;
                        d++;
                    } while(arr[i] == arr[i - 1]);
                else
                    do
                    {
                        if(d > 3)
                            d -= 4;
                        arr[i] = d;
                        d++;
                    } while(arr[i] == arr[i - 2]);
            }

            for(int k = 0; k < n; k++)
                sum += color[k][arr[k]];

            if(min > sum)
            {
                min = sum;
                sum = 0;
            }
        }

        System.out.println(sum);
    }
}
