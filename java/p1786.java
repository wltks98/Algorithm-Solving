// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1786.java

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class p1786
{

    public p1786()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String pattern = br.readLine();
        li = new ArrayList();
        KMP(origin, pattern);
        System.out.println(cnt);
        for(int i = 0; i < cnt; i++)
            System.out.println(li.get(i));

    }

    static int[] getPi(String ptn)
    {
        int pi[] = new int[ptn.length()];
        int j = 0;
        for(int i = 1; i < ptn.length(); i++)
        {
            while(j > 0 && ptn.charAt(i) != ptn.charAt(j)) 
                j = pi[j - 1];
            if(ptn.charAt(i) == ptn.charAt(j))
                pi[i] = ++j;
        }

        return pi;
    }

    static void KMP(String org, String ptn)
    {
        int pi[] = getPi(ptn);
        int j = 0;
        for(int i = 0; i < org.length(); i++)
        {
            while(j > 0 && org.charAt(i) != ptn.charAt(j)) 
                j = pi[j - 1];
            if(org.charAt(i) == ptn.charAt(j))
                if(j == ptn.length() - 1)
                {
                    cnt++;
                    li.add(Integer.valueOf((i - j) + 1));
                    j = pi[j];
                } else
                {
                    j++;
                }
        }

    }

    static int cnt = 0;
    static List li;

}
