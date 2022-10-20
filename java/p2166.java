// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2166.java

import java.io.*;
import java.util.StringTokenizer;

public class p2166
{

    public p2166()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long x[] = new long[N + 1];
        long y[] = new long[N + 1];
        long sum_a = 0L;
        long sum_b = 0L;
        for(int i = 0; i < N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        x[N] = x[0];
        y[N] = y[0];
        for(int i = 0; i < N; i++)
        {
            sum_a += x[i] * y[i + 1];
            sum_b += x[i + 1] * y[i];
        }

        String area = String.format("%.1f", new Object[] {
            Double.valueOf((double)Math.abs(sum_a - sum_b) / 2D)
        });
        bw.write(area);
        br.close();
        bw.flush();
        bw.close();
    }
}
