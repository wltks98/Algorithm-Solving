// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2579.java

import java.io.*;

public class p2579
{

    public p2579()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int f[] = new int[T + 1];
        int cache[] = new int[T + 1];
        for(int i = 1; i <= T; i++)
            f[i] = Integer.parseInt(br.readLine());

        cache[1] = f[1];
        cache[2] = f[2] + f[1];
        cache[3] = Math.max(f[1] + f[3], f[2] + f[3]);
        for(int i = 4; i <= T; i++)
            cache[i] = Math.max(cache[i - 3] + f[i] + f[i - 1], cache[i - 2] + f[i]);

        System.out.println(cache[T]);
    }
}
