// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p9375.java

import java.io.*;
import java.util.*;

public class p9375
{

    public p9375()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        for(int i = 0; i < a; i++)
        {
            Map map = new HashMap();
            int b = Integer.parseInt(br.readLine());
            for(int j = 0; j < b; j++)
            {
                String type = br.readLine().split(" ")[1];
                if(map.containsKey(type))
                    map.put(type, Integer.valueOf(((Integer)map.get(type)).intValue() + 1));
                else
                    map.put(type, Integer.valueOf(1));
            }

            int x = 1;
            for(Iterator iterator = map.values().iterator(); iterator.hasNext();)
            {
                int y = ((Integer)iterator.next()).intValue();
                x *= y + 1;
            }

            System.out.println(x - 1);
        }

    }
}
