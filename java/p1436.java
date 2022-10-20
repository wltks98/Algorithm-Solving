// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1436.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1436
{

    public p1436()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ct = 0;
        int save[] = new int[50000];
        for(int i = 0; i < 0x4c4b40; i++)
            if(Integer.toString(i).contains("666"))
            {
                ct++;
                save[ct] = i;
            }

        System.out.println(save[n]);
    }
}
