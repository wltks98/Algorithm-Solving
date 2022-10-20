// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11399.java

import java.io.PrintStream;
import java.util.*;

public class p11399
{

    public p11399()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n];
        int p2[] = new int[n];
        for(int i = 0; i < n; i++)
            p[i] = sc.nextInt();

        ArrayList list = new ArrayList();
        for(int i = 0; i < n; i++)
            list.add(Integer.valueOf(p[i]));

        Collections.sort(list);
        int sum = 0;
        p2[0] = ((Integer)list.get(0)).intValue();
        for(int i = 1; i < n; i++)
        {
            p2[i] = ((Integer)list.get(i)).intValue();
            for(int j = 0; j < i; j++)
                p2[i] += ((Integer)list.get(j)).intValue();

        }

        for(int i = 0; i < n; i++)
        {
            sum += p2[i];
            System.out.println(p2[i]);
        }

        System.out.println(sum);
    }
}
