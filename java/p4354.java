// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p4354.java

import java.io.*;

public class p4354
{

    public p4354()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        int max;
        for(; !(str = br.readLine()).equals("."); sb.append(max).append("\n"))
        {
            int len = str.length();
            max = 0;
            max = getMaxKMP(str);
        }

        System.out.print(sb.toString());
    }

    static int getMaxKMP(String str)
    {
        int j = 0;
        int max = 0;
        int len = str.length();
        int pi[] = new int[len];
        for(int i = 1; i < len; i++)
        {
            while(j > 0 && str.charAt(i) != str.charAt(j)) 
                j = pi[j - 1];
            if(str.charAt(i) == str.charAt(j))
                pi[i] = ++j;
        }

        return len % (len - pi[len - 1]) == 0 ? len / (len - pi[len - 1]) : 1;
    }
}
