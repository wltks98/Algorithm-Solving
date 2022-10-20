// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p14425.java

import java.io.PrintStream;
import java.util.*;

public class p14425
{

    public p14425()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner sc = new Scanner(System.in);
        TreeMap map = new TreeMap();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            TreeMap target = map;
            String names = sc.next();
            for(int j = 0; j < names.length(); j++)
            {
                char name = names.charAt(j);
                if(target.get(Character.valueOf(name)) == null)
                    target.put(Character.valueOf(name), new TreeMap());
                target = (TreeMap)target.get(Character.valueOf(name));
            }

        }

        for(int i = 0; i < m; i++)
        {
            String pt = sc.next();
            check(map, pt, 0);
        }

        System.out.println(count);
    }

    static void check(TreeMap map, String pt, int n)
    {
        for(Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            Object s = iterator.next();
            if(pt.charAt(n) == ((Character)s).charValue())
            {
                if(n == pt.length() - 1)
                {
                    System.out.println(pt);
                    count++;
                    return;
                }
                check((TreeMap)map.get(s), pt, n + 1);
            }
        }

    }

    static StringBuilder result = new StringBuilder();
    static int count = 0;

}
