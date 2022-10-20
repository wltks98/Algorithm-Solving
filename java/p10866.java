// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10866.java

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class p10866
{

    public p10866()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList list = new ArrayList();
        for(int i = 0; i < n; i++)
        {
            String q = sc.next();
            String s;
            switch((s = q).hashCode())
            {
            default:
                break;

            case -1254346053: 
                int x;
                int x2;
                if(s.equals("pop_front"))
                    System.out.println(pop_front(list));
                break;

            case -769167636: 
                if(s.equals("push_back"))
                {
                    x2 = sc.nextInt();
                    push_back(list, x2);
                }
                break;

            case 3015911: 
                if(s.equals("back"))
                    System.out.println(back(list));
                break;

            case 3530753: 
                if(s.equals("size"))
                    System.out.println(size(list));
                break;

            case 96634189: 
                if(s.equals("empty"))
                    System.out.println(empty(list));
                break;

            case 97705513: 
                if(s.equals("front"))
                    System.out.println(front(list));
                break;

            case 652138005: 
                if(s.equals("pop_back"))
                    System.out.println(pop_back(list));
                break;

            case 1929819332: 
                if(s.equals("push_front"))
                {
                    x = sc.nextInt();
                    push_front(list, x);
                }
                break;
            }
        }

    }

    public static void push_front(ArrayList list, int x)
    {
        list.add(--f, Integer.valueOf(x));
        b++;
    }

    public static int pop_front(ArrayList list)
    {
        if(f == b)
            return -1;
        else
            return ((Integer)list.get(f++)).intValue();
    }

    public static void push_back(ArrayList list, int x)
    {
        list.add(Integer.valueOf(x));
        b++;
    }

    public static int pop_back(ArrayList list)
    {
        if(f == b)
            return -1;
        else
            return ((Integer)list.get(--b)).intValue();
    }

    public static int size(ArrayList list)
    {
        return b - f;
    }

    public static int empty(ArrayList list)
    {
        return f != b ? 0 : 1;
    }

    public static int front(ArrayList list)
    {
        if(f == b)
            return -1;
        else
            return ((Integer)list.get(f)).intValue();
    }

    public static int back(ArrayList list)
    {
        if(f == b)
            return -1;
        else
            return ((Integer)list.get(b - 1)).intValue();
    }

    static int f = 0;
    static int b = 0;

}
