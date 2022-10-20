// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11723.java

import java.io.PrintStream;
import java.util.Scanner;

public class p11723
{

    public p11723()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int T = scan.nextInt();
        int S = 0;
        for(int i = 0; i < T; i++)
        {
            String command = scan.next();
            if(command.equals("add"))
            {
                int x = scan.nextInt();
                S |= 1 << x;
            } else
            if(command.equals("remove"))
            {
                int x = scan.nextInt();
                S &= ~(1 << x);
            } else
            if(command.equals("check"))
            {
                int x = scan.nextInt();
                if((S & 1 << x) > 0)
                    result.append("1\n");
                else
                    result.append("0\n");
            } else
            if(command.equals("toggle"))
            {
                int x = scan.nextInt();
                S ^= 1 << x;
            } else
            if(command.equals("all"))
                S = 0x1fffff;
            else
                S = 0;
        }

        System.out.println(result);
    }
}
