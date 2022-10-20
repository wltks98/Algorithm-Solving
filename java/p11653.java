// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11653.java

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class p11653
{

    public p11653()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList list = new ArrayList();
        int i = 2;
        while(n != 1) 
            if(n % i == 0)
            {
                list.add(Integer.valueOf(i));
                n /= i;
            } else
            {
                i++;
            }
        for(int j = 0; j < list.size(); j++)
            System.out.println(list.get(j));

    }
}
