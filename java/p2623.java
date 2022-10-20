// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2623.java

import java.io.*;
import java.util.*;

public class p2623
{

    public p2623()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList list[] = new LinkedList[n + 1];
        int link[] = new int[n + 1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList();

        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k != 1)
            {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(Integer.valueOf(b));
                link[b]++;
                a = b;
                for(int j = 2; j < k; j++)
                {
                    b = Integer.parseInt(st.nextToken());
                    list[a].add(Integer.valueOf(b));
                    link[b]++;
                    a = b;
                }

            }
        }

        Queue q = new LinkedList();
        for(int i = 1; i <= n; i++)
            if(link[i] == 0)
                q.offer(Integer.valueOf(i));

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) 
        {
            int now = ((Integer)q.poll()).intValue();
            sb.append((new StringBuilder(String.valueOf(now))).append("\n").toString());
            for(Iterator it = list[now].iterator(); it.hasNext();)
            {
                int index = ((Integer)it.next()).intValue();
                link[index]--;
                if(link[index] == 0)
                    q.offer(Integer.valueOf(index));
            }

        }
        for(int i = 1; i < n + 1; i++)
            if(link[i] != 0)
            {
                System.out.println(0);
                return;
            }

        System.out.println(sb.toString());
    }
}
