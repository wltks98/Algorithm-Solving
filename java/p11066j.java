// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11066j.java

import java.io.PrintStream;
import java.util.Scanner;

public class p11066j
{

    public p11066j()
    {
    }

    public static int minPrice(int n)
    {
        for(int i = 1; i < n; i++)
            price[i][i] = 0;

        for(int j = 1; j <= n - 1; j++)
            price[j][j + 1] = fileSize[j] + fileSize[j + 1];

        for(int i = 2; i <= n; i++)
        {
            for(int j = 1; j <= n - i; j++)
            {
                int tmpM = 0x2faf080;
                for(int k = j; k < j + i; k++)
                {
                    int tmpP = price[j][k] + price[k + 1][j + i];
                    if(tmpM > tmpP)
                        tmpM = tmpP;
                }

                tmpM += sumPrice[j + i] - sumPrice[j - 1];
                price[j][j + i] = tmpM;
            }

        }

        return price[1][n];
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++)
        {
            int k = scan.nextInt();
            for(int j = 1; j <= k; j++)
            {
                int a = scan.nextInt();
                fileSize[j] = a;
                sumPrice[j] = sumPrice[j - 1] + a;
            }

            System.out.println(minPrice(k));
        }

    }

    public static int fileSize[] = new int[501];
    public static int price[][] = new int[501][501];
    public static int sumPrice[] = new int[501];

}
