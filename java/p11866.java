// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11866.java

import java.io.PrintStream;
import java.util.*;

public class p11866
{

    public p11866()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Queue q = new LinkedList();
        int N = in.nextInt();
        int K = in.nextInt();
        for(int i = 1; i <= N; i++)
            q.add(Integer.valueOf(i));

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for(; q.size() > 1; sb.append(q.poll()).append(", "))
        {
            for(int i = 0; i < K - 1; i++)
            {
                int val = ((Integer)q.poll()).intValue();
                q.offer(Integer.valueOf(val));
            }

        }

        sb.append(q.poll()).append('>');
        System.out.println(sb);
    }
}
