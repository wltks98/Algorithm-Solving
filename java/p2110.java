// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2110.java

import java.io.*;
import java.util.*;

public class p2110
{

    public p2110()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List list = new ArrayList();
        list.add(Integer.valueOf(0));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
        {
            int value = Integer.parseInt(st.nextToken());
            if(value > ((Integer)list.get(list.size() - 1)).intValue())
            {
                list.add(Integer.valueOf(value));
            } else
            {
                int left = 0;
                int right;
                for(right = list.size() - 1; left < right;)
                {
                    int mid = (left + right) / 2;
                    if(value > ((Integer)list.get(mid)).intValue())
                        left = mid + 1;
                    else
                        right = mid;
                }

                list.set(right, Integer.valueOf(value));
            }
        }

        System.out.println(list);
        bw.write((new StringBuilder(String.valueOf(list.size() - 1))).append("\n").toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
