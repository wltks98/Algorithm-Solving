// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p20040.java

import java.io.*;
import java.util.StringTokenizer;

public class p20040
{

    public p20040()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        init();
        for(int i = 1; i <= M; i++)
        {
            st = new StringTokenizer(br.readLine());
            if(isCycle(stoi(st.nextToken()), stoi(st.nextToken())))
            {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    private static int find(int a)
    {
        return parents[a] >= 0 ? (parents[a] = find(parents[a])) : a;
    }

    private static boolean isCycle(int a, int b)
    {
        if((a = find(a)) == (b = find(b)))
        {
            return true;
        } else
        {
            parents[a] = b;
            return false;
        }
    }

    private static void init()
    {
        parents = new int[N];
        for(int i = 0; i < N; i++)
            parents[i] = -1;

    }

    private static int stoi(String input)
    {
        return Integer.parseInt(input);
    }

    static int N;
    static int M;
    static int parents[];
}
