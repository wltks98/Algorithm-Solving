// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11401.java

import java.io.*;
import java.util.StringTokenizer;

public class p11401
{

    public p11401()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long numer = factorial(N);
        long denom = (factorial(K) * factorial(N - K)) % 0x3b9aca07L;
        System.out.println((numer * pow(denom, 0x3b9aca05L)) % 0x3b9aca07L);
    }

    public static long factorial(long N)
    {
        long fac = 1L;
        for(; N > 1L; N--)
            fac = (fac * N) % 0x3b9aca07L;

        return fac;
    }

    public static long pow(long base, long expo)
    {
        long result = 1L;
        for(; expo > 0L; expo /= 2L)
        {
            if(expo % 2L == 1L)
            {
                result *= base;
                result %= 0x3b9aca07L;
            }
            base = (base * base) % 0x3b9aca07L;
        }

        return result;
    }

    static final long P = 0x3b9aca07L;
}
