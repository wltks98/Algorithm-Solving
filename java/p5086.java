// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p5086.java

import java.io.PrintStream;
import java.util.Scanner;

public class p5086
{

    public p5086()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        do
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x != 0 || y != 0)
            {
                if(x % y == 0)
                    sb.append("multiple\n");
                else
                if(y % x == 0)
                    sb.append("factor\n");
                else
                    sb.append("neither\n");
            } else
            {
                System.out.println(sb);
                return;
            }
        } while(true);
    }
}
