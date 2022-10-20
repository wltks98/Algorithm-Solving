// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1208.java

import java.io.*;
import java.util.*;

public class p1208
{

    public p1208()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sarr[] = br.readLine().split(" ");
        N = Integer.parseInt(sarr[0]);
        S = Integer.parseInt(sarr[1]);
        arr = new long[N];
        sarr = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            arr[i] = Long.parseLong(sarr[i]);

        getSubsequence(0, N / 2, 0L, left);
        getSubsequence(N / 2, N, 0L, right);
        Collections.sort(left);
        Collections.sort(right);
        long cnt = getCnt();
        if(S == 0)
            cnt--;
        bw.write((new StringBuilder(String.valueOf(cnt))).append("\n").toString());
        bw.flush();
    }

    public static void getSubsequence(int idx, int end, long sum, List list)
    {
        if(idx == end)
        {
            list.add(Long.valueOf(sum));
            return;
        } else
        {
            getSubsequence(idx + 1, end, sum + arr[idx], list);
            getSubsequence(idx + 1, end, sum, list);
            return;
        }
    }

    public static long getCnt()
    {
        int pl = 0;
        int pr = right.size() - 1;
        long cnt = 0L;
        while(pl < left.size() && pr >= 0) 
        {
            long sum = ((Long)left.get(pl)).longValue() + ((Long)right.get(pr)).longValue();
            if(sum == (long)S)
            {
                long a = ((Long)left.get(pl)).longValue();
                long cnt1;
                for(cnt1 = 0L; pl < left.size() && ((Long)left.get(pl)).longValue() == a; cnt1++)
                    pl++;

                long b = ((Long)right.get(pr)).longValue();
                long cnt2;
                for(cnt2 = 0L; pr >= 0 && ((Long)right.get(pr)).longValue() == b; cnt2++)
                    pr--;

                cnt += cnt1 * cnt2;
            } else
            if(sum < (long)S)
                pl++;
            else
                pr--;
        }
        return cnt;
    }

    static int N;
    static int S;
    static long arr[];
    static List left = new ArrayList();
    static List right = new ArrayList();

}
