// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1027.java

import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p1027
{

    public p1027()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue q = new PriorityQueue();
        int a = 0;
        for(int i = 0; i < n; i++)
        {
            a = sc.nextInt();
            if(a == 0)
            {
                if(q.size() == 0)
                    System.out.println(0);
                else
                    System.out.println(q.poll());
            } else
            {
                q.offer(Integer.valueOf(a));
            }
        }

    }
}
