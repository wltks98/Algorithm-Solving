// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p9012.java

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

public class p9012
{

    public p9012()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuffer br = new StringBuffer();
        Stack stack = new Stack();
        String a = sc.nextLine();
        stack.add(Character.valueOf(a.charAt(0)));
        for(int i = 1; i < a.length(); i++)
        {
            if(a.charAt(i) == '(')
                stack.push(Character.valueOf(a.charAt(i)));
            if(a.charAt(i) == ')')
                if(stack.isEmpty())
                    stack.push(Character.valueOf(')'));
                else
                if(((Character)stack.peek()).charValue() == '(')
                    stack.pop();
        }

        if(stack.isEmpty())
            br.append("YES\n");
        else
            br.append("NO\n");
        System.out.println(br);
    }
}
