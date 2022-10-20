// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p18258.java

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class p18258
{

    public p18258()
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

            case 111185: 
                int x;
                if(s.equals("pop"))
                    System.out.println(pop(list));
                break;

            case 3015911: 
                if(s.equals("back"))
                    System.out.println(back(list));
                break;

            case 3452698: 
                if(s.equals("push"))
                {
                    x = sc.nextInt();
                    push(list, x);
                }
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
            }
        }

    }

    public static void push(ArrayList list, int x)
    {
        list.add(Integer.valueOf(x));
        b++;
    }

    public static int pop(ArrayList list)
    {
        if(f == b)
            return -1;
        else
            return ((Integer)list.get(f++)).intValue();
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
