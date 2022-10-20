// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1629.java

import java.io.*;
import java.util.StringTokenizer;

public class p1629
{

    public p1629()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long result = calcPow(A, B, C);
        System.out.println(result);
        br.close();
    }

    public static long calcPow(long a, long b, long c)
    {
        if(b == 0L)
            return 1L;
        long n = calcPow(a, b / 2L, c);
        long temp = (n * n) % c;
        if(b % 2L == 0L)
            return temp;
        else
            return (a * temp) % c;
    }
}
