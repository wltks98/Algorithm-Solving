// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2568.java

import java.io.*;
import java.util.*;

public class p2568
{

    public p2568()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num[][] = new int[n + 1][2];
        int dp[] = new int[n + 1];
        int maxInstall = 1;
        for(int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num[i][0] = Integer.parseInt(st.nextToken());
            num[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num, new Comparator() {

            public int compare(int o1[], int o2[])
            {
                return o1[0] - o2[0];
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((int[])obj, (int[])obj1);
            }

        }
);
        ArrayList list = new ArrayList();
        for(int i = 1; i <= n; i++)
        {
            dp[i] = 1;
            list = new ArrayList();
            for(int j = 1; j < i; j++)
                if(num[j][1] < num[i][1])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    list.add(Integer.valueOf(j));
                }

            maxInstall = Math.max(maxInstall, dp[i]);
        }

        int i;
        for(Iterator iterator = list.iterator(); iterator.hasNext(); System.out.println(i))
            i = ((Integer)iterator.next()).intValue();

        System.out.println(n - maxInstall);
    }
}
