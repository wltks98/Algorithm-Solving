// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10773.java

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class p10773
{

    public p10773()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s[] = new int[n];
        int w = -1;
        int sum = 0;
        ArrayList stack = new ArrayList();
        for(int i = 0; i < n; i++)
            s[i] = sc.nextInt();

        for(int i = 0; i < n; i++)
            if(s[i] == 0)
            {
                stack.remove(w);
                w--;
            } else
            {
                stack.add(Integer.valueOf(s[i]));
                w++;
            }

        for(int i = 0; i < stack.size(); i++)
            sum += ((Integer)stack.get(i)).intValue();

        System.out.println(sum);
    }
}
