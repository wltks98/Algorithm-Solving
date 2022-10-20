// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p17386.java

import java.io.PrintStream;
import java.util.Scanner;

public class p17386
{
    static class Pair
    {

        public boolean cmp(Pair o)
        {
            if(y > o.y)
                return true;
            return y == o.y && x >= o.x;
        }

        public boolean equals(Pair obj)
        {
            return x == obj.x && y == obj.y;
        }

        long y;
        long x;

        public Pair(long x, long y)
        {
            this.y = y;
            this.x = x;
        }
    }


    public p17386()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Pair a = new Pair(sc.nextLong(), sc.nextLong());
        Pair b = new Pair(sc.nextLong(), sc.nextLong());
        Pair c = new Pair(sc.nextLong(), sc.nextLong());
        Pair d = new Pair(sc.nextLong(), sc.nextLong());
        if(Solve(a, b, c, d))
            System.out.println(1);
        else
            System.out.println(0);
    }

    static long ccw(Pair a, Pair b, Pair c)
    {
        long op = a.x * b.y + b.x * c.y + c.x * a.y;
        op -= a.y * b.x + b.y * c.x + c.y * a.x;
        if(op > 0L)
            return 1L;
        return op != 0L ? -1L : 0L;
    }

    public static boolean Solve(Pair a, Pair b, Pair c, Pair d)
    {
        long abc = ccw(a, b, c);
        long abd = ccw(a, b, d);
        long cda = ccw(c, d, a);
        long cdb = ccw(c, d, b);
        if(abc * abd == 0L && cda * cdb == 0L)
        {
            if(a.cmp(b))
            {
                Pair tmp = a;
                a = b;
                b = tmp;
            }
            if(c.cmp(d))
            {
                Pair tmp = c;
                c = d;
                d = tmp;
            }
            if(b.equals(c) || a.equals(d))
                return true;
            else
                return b.cmp(c) ^ a.cmp(d);
        }
        return abc * abd <= 0L && cda * cdb <= 0L;
    }
}
