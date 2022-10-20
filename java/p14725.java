// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p14725.java

import java.io.*;
import java.util.*;

public class p14725
{

    public p14725()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap map = new TreeMap();
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            TreeMap target = map;
            for(int j = 0; j < n; j++)
            {
                String name = st.nextToken();
                if(target.get(name) == null)
                    target.put(name, new TreeMap());
                target = (TreeMap)target.get(name);
            }

        }

        getresult(map, 0);
        System.out.println(result);
    }

    static void getresult(TreeMap map, int n)
    {
        Object s;
        for(Iterator iterator = map.keySet().iterator(); iterator.hasNext(); getresult((TreeMap)map.get(s), n + 1))
        {
            s = iterator.next();
            for(int i = 0; i < n; i++)
                result.append("--");

            result.append((new StringBuilder()).append(s).append("\n").toString());
        }

    }

    static StringBuilder result = new StringBuilder();

}
