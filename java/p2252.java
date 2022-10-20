// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2252.java

import java.io.*;
import java.util.*;

public class p2252
{

    public p2252()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        LinkedList list[] = new LinkedList[n + 1];
        int link[] = new int[n + 1];
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList();

        for(int i = 0; i < m; i++)
        {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            list[a].add(Integer.valueOf(b));
            link[b]++;
        }

        Queue q = new LinkedList();
        for(int i = 1; i <= n; i++)
            if(link[i] == 0)
                q.offer(Integer.valueOf(i));

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) 
        {
            int now = ((Integer)q.poll()).intValue();
            sb.append((new StringBuilder(String.valueOf(now))).append(" ").toString());
            for(Iterator it = list[now].iterator(); it.hasNext();)
            {
                int index = ((Integer)it.next()).intValue();
                link[index]--;
                if(link[index] == 0)
                    q.offer(Integer.valueOf(index));
            }

        }
        System.out.println(sb.toString());
    }
}
