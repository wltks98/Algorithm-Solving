// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1300.java

import java.io.*;

public class p1300
{

    public p1300()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int left = 1;
        int right = k;
        int ans = 0;
        while(left <= right) 
        {
            int mid = (left + right) / 2;
            int cnt = getCnt(mid, n);
            if(cnt >= k)
            {
                ans = mid;
                right = mid - 1;
            } else
            {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static int getCnt(int x, int n)
    {
        int cnt = 0;
        for(int i = 1; i <= n; i++)
            cnt += Math.min(x / i, n);

        return cnt;
    }
}
