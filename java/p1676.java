// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1676.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1676
{

    public p1676()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = 0;
        for(; num >= 5; num /= 5)
            count += num / 5;

        System.out.println(count);
    }
}
