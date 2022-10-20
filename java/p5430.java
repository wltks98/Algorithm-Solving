// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p5430.java

import java.io.PrintStream;
import java.util.*;

public class p5430
{

    public p5430()
    {
    }

    public static void main(String args[])
    {
        StringBuffer s = new StringBuffer("");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {
            Deque q = new LinkedList();
            String cmd = sc.next();
            int n = sc.nextInt();
            String arr = sc.next();
            for(int j = 0; j < n; j++)
                q.add(Character.valueOf(arr.charAt(2 * j + 1)));

            int error = 0;
            for(int j = 0; j < cmd.length(); j++)
            {
                if(cmd.charAt(j) == 'R')
                {
                    Deque q2 = new LinkedList();
                    for(int k = 0; k < n; k++)
                        q2.add((Character)q.pollLast());

                    q = q2;
                }
                if(cmd.charAt(j) != 'D')
                    continue;
                if(q.size() == 0)
                {
                    s.append("error\n");
                    error = 1;
                    break;
                }
                q.pollFirst();
            }

            if(error == 0)
                s.append((new StringBuilder()).append(q).append("\n").toString());
        }

        System.out.println(s);
    }
}
