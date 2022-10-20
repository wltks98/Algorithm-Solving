// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1541.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1541
{

    public p1541()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int sum = 0x7fffffff;
        String subtraction[] = in.nextLine().split("-");
        for(int i = 0; i < subtraction.length; i++)
        {
            int temp = 0;
            String addition[] = subtraction[i].split("\\+");
            for(int j = 0; j < addition.length; j++)
                temp += Integer.parseInt(addition[j]);

            if(sum == 0x7fffffff)
                sum = temp;
            else
                sum -= temp;
        }

        System.out.println(sum);
    }
}
