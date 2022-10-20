// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11279.java

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class p11279
{

    public p11279()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());
        for(int i = 0; i < n; i++)
        {
            int op = Integer.parseInt(br.readLine());
            if(op == 0)
            {
                if(pq.isEmpty())
                    sb.append("0\n");
                else
                    sb.append((new StringBuilder()).append(pq.poll()).append("\n").toString());
            } else
            {
                pq.offer(Integer.valueOf(op));
            }
        }

        System.out.print(sb.toString());
    }
}
