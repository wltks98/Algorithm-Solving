// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10816.java

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10816
{

    public p10816()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arrN = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arrN.length; i++)
            arrN[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arrN);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            bw.append((new StringBuilder(String.valueOf(upper_bound(num) - lower_bound(num)))).append(" ").toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int lower_bound(int num)
    {
        int start = 0;
        for(int last = arrN.length; start < last;)
        {
            int mid = start + (last - start) / 2;
            if(num <= arrN[mid])
                last = mid;
            else
                start = mid + 1;
        }

        return start;
    }

    static int upper_bound(int num)
    {
        int start = 0;
        for(int last = arrN.length; start < last;)
        {
            int mid = start + (last - start) / 2;
            if(num >= arrN[mid])
                start = mid + 1;
            else
                last = mid;
        }

        return start;
    }

    static int arrN[];
}
