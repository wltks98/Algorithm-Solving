// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1874.java

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class p1874
{

    public p1874()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        int N = in.nextInt();
        int start = 0;
        while(N-- > 0) 
        {
            int value = in.nextInt();
            if(value > start)
            {
                for(int i = start + 1; i <= value; i++)
                {
                    stack.push(Integer.valueOf(i));
                    sb.append('+').append('\n');
                }

                start = value;
            } else
            if(((Integer)stack.peek()).intValue() != value)
            {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
