// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p17298.java

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17298
{

    public p17298()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int result[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack s = new Stack();
        for(int i = 0; i < N; i++)
        {
            int number;
            for(number = Integer.parseInt(st.nextToken()); !s.isEmpty() && number > ((int[])s.peek())[0]; result[((int[])s.pop())[1]] = number);
            s.push(new int[] {
                number, i
            });
        }

        int ai[];
        int k = (ai = result).length;
        for(int j = 0; j < k; j++)
        {
            int r = ai[j];
            if(r == 0)
                r = -1;
            bw.append((new StringBuilder(String.valueOf(r))).append("\n").toString());
        }

        bw.flush();
    }
}
