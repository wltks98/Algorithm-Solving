// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1005.java

import java.io.*;
import java.util.*;

public class p1005
{

    public p1005()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int p = 0; p < t; p++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int cost[] = new int[n + 1];
            int link[] = new int[n + 1];
            int dp[] = new int[n + 1];
            LinkedList list[] = new LinkedList[n + 1];
            for(int i = 1; i <= n; i++)
                list[i] = new LinkedList();

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++)
                cost[i] = Integer.parseInt(st.nextToken());

            for(int i = 0; i < k; i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(Integer.valueOf(b));
                link[b]++;
            }

            Queue q = new LinkedList();
            for(int i = 1; i <= n; i++)
                if(link[i] == 0)
                {
                    q.offer(Integer.valueOf(i));
                    dp[i] = cost[i];
                }

            while(!q.isEmpty()) 
            {
                int now = ((Integer)q.poll()).intValue();
                for(Iterator it = list[now].iterator(); it.hasNext();)
                {
                    int index = ((Integer)it.next()).intValue();
                    link[index]--;
                    dp[index] = Math.max(dp[now] + cost[index], dp[index]);
                    if(link[index] == 0)
                        q.offer(Integer.valueOf(index));
                }

            }
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            sb.append((new StringBuilder(String.valueOf(dp[w]))).append("\n").toString());
        }

        System.out.println(sb);
    }
}
