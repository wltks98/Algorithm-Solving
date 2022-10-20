// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2231.java

import java.io.PrintStream;
import java.util.Scanner;

public class p2231
{

    public p2231()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
        {
            if(getSum(i) != n)
                continue;
            constructor = i;
            break;
        }

        System.out.println(constructor);
    }

    public static int getSum(int n)
    {
        String strN = Integer.toString(n);
        int lenOfN = strN.length();
        sum = n;
        for(int i = 0; i < lenOfN; i++)
            sum += Integer.parseInt((new StringBuilder(String.valueOf(strN.charAt(i)))).toString());

        return sum;
    }

    static int n;
    static int sum;
    static int constructor;
}
