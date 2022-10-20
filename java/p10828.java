// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10828.java

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class p10828
{

    public p10828()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = -1;
        String p[] = new String[n];
        ArrayList list = new ArrayList();
        ArrayList stack = new ArrayList();
        for(int i = 0; i < n; i++)
        {
            p[i] = sc.next();
            if(p[i].equals("push"))
                list.add(Integer.valueOf(sc.nextInt()));
        }

        int j = 0;
        for(int i = 0; i < n; i++)
        {
            String s1;
            switch((s1 = p[i]).hashCode())
            {
            default:
                break;

            case 111185: 
                if(!s1.equals("pop"))
                    break;
                if(s >= 0)
                {
                    System.out.println(stack.get(s));
                    stack.remove(s);
                    s--;
                } else
                {
                    System.out.println(-1);
                }
                break;

            case 115029: 
                if(!s1.equals("top"))
                    break;
                if(s >= 0)
                    System.out.println(stack.get(s));
                else
                    System.out.println(-1);
                break;

            case 3452698: 
                if(s1.equals("push"))
                {
                    stack.add((Integer)list.get(j));
                    j++;
                    s++;
                }
                break;

            case 3530753: 
                if(s1.equals("size"))
                    System.out.println(s + 1);
                break;

            case 96634189: 
                if(!s1.equals("empty"))
                    break;
                if(s == -1)
                    System.out.println(1);
                else
                    System.out.println(0);
                break;
            }
        }

    }
}
