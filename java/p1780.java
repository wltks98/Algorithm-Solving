// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1780.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1780
{

    public p1780()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        a = new int[m][m];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

        }

        div(0, 0, m);
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
    }

    public static boolean check(int x, int y, int n)
    {
        int num = a[x][y];
        if(n == 1)
            return true;
        for(int i = y; i < y + n; i++)
        {
            for(int j = x; j < x + n; j++)
                if(num != a[i][j])
                    return false;

        }

        return true;
    }

    public static void div(int x, int y, int n)
    {
        System.out.println("d");
        if(check(x, y, n))
        {
            switch(a[x][y])
            {
            case -1: 
                count1++;
                break;

            case 0: // '\0'
                count2++;
                break;

            case 1: // '\001'
                count3++;
                break;
            }
            return;
        } else
        {
            int newSize = n / 3;
            div(y, x, n / 3);
            div(y, x + newSize, n / 3);
            div(y, x + 2 * newSize, n / 3);
            div(y + newSize, x, n / 3);
            div(y + newSize, x + newSize, n / 3);
            div(y + newSize, x + 2 * newSize, n / 3);
            div(y + 2 * newSize, x, n / 3);
            div(y + 2 * newSize, x + newSize, n / 3);
            div(y + 2 * newSize, x + 2 * newSize, n / 3);
            return;
        }
    }

    static int m;
    static int a[][];
    static int count1 = 0;
    static int count2;
    static int count3;

}
