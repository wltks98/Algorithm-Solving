// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p4949.java

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class p4949
{

    public p4949()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        do
        {
            String s = in.nextLine();
            if(!s.equals("."))
                System.out.println(solve(s));
            else
                return;
        } while(true);
    }

    public static String solve(String s)
    {
        Stack stack = new Stack();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[')
                stack.push(Character.valueOf(c));
            else
            if(c == ')')
            {
                if(stack.empty() || ((Character)stack.peek()).charValue() != '(')
                    return "no";
                stack.pop();
            } else
            if(c == ']')
            {
                if(stack.empty() || ((Character)stack.peek()).charValue() != '[')
                    return "no";
                stack.pop();
            }
        }

        if(stack.empty())
            return "yes";
        else
            return "no";
    }
}
