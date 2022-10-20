// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11286.java

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p11286
{

    public p11286()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue heap = new PriorityQueue(new Comparator() {

            public int compare(Integer o1, Integer o2)
            {
                if(Math.abs(o1.intValue()) > Math.abs(o2.intValue()))
                    return 1;
                if(Math.abs(o1.intValue()) < Math.abs(o2.intValue()))
                    return -1;
                if(o1.intValue() > o2.intValue())
                    return 1;
                return o1.intValue() >= o2.intValue() ? 0 : -1;
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Integer)obj, (Integer)obj1);
            }

        }
);
        for(int i = 0; i < n; i++)
        {
            int x = Integer.parseInt(br.readLine());
            if(x != 0)
                heap.add(Integer.valueOf(x));
            else
            if(heap.size() == 0)
                System.out.println(0);
            else
                System.out.println(heap.poll());
        }

    }
}
