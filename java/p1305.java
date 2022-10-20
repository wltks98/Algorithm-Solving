// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1305.java

import java.io.*;

public class p1305
{

    public p1305()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine()).intValue();
        String str = br.readLine();
        int lastPi = getLastPi(str);
        System.out.println(n - lastPi);
    }

    static int getLastPi(String str)
    {
        int len = str.length();
        int j = 0;
        int max = 0;
        int pi[] = new int[len];
        for(int i = 1; i < len; i++)
        {
            while(j > 0 && str.charAt(j) != str.charAt(i)) 
                j = pi[j - 1];
            if(str.charAt(j) == str.charAt(i))
                pi[i] = ++j;
        }

        return pi[len - 1];
    }
}
