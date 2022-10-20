// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2164.java

import java.io.PrintStream;
import java.util.*;

public class p2164
{

    public p2164()
    {
    }

    public static void main(String args[])
    {
        Queue q = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++)
            q.offer(Integer.valueOf(i));

        for(; q.size() != 1; q.offer((Integer)q.poll()))
            q.poll();

        System.out.println(q.poll());
    }
}
