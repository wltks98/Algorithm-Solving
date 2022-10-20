// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10266.java

import java.io.*;
import java.util.StringTokenizer;

public class p10266
{

    public p10266()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(StringTokenizer st = new StringTokenizer(br.readLine()); st.hasMoreTokens();)
            strIndex[Integer.parseInt(st.nextToken())] = 1;

        for(StringTokenizer st = new StringTokenizer(br.readLine()); st.hasMoreTokens();)
            patternIndex[Integer.parseInt(st.nextToken())] = 1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 0x57e40; i++)
            sb.append(strIndex[i]);

        String str = sb.append(sb).toString();
        sb = new StringBuilder();
        for(int i = 0; i < 0x57e40; i++)
            sb.append(patternIndex[i]);

        String pattern = sb.toString();
        if(KMP(str, pattern) == 1)
            System.out.println("possible");
        else
            System.out.println("impossible");
    }

    static int[] getPi(String Pattern)
    {
        int pi[] = new int[Pattern.length()];
        int j = 0;
        for(int i = 1; i < Pattern.length(); i++)
        {
            while(j > 0 && Pattern.charAt(i) != Pattern.charAt(j)) 
                j = pi[j - 1];
            if(Pattern.charAt(i) == Pattern.charAt(j))
                pi[i] = ++j;
        }

        return pi;
    }

    static int KMP(String Origin, String Pattern)
    {
        int j = 0;
        int pi[] = getPi(Pattern);
        for(int i = 0; i < Origin.length(); i++)
        {
            while(j > 0 && Origin.charAt(i) != Pattern.charAt(j)) 
                j = pi[j - 1];
            if(Origin.charAt(i) == Pattern.charAt(j))
            {
                if(j == Pattern.length() - 1)
                    return 1;
                j++;
            }
        }

        return 0;
    }

    static int N;
    static int strIndex[] = new int[0x57e40];
    static int patternIndex[] = new int[0x57e40];

}
