// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10217.java

import java.io.*;
import java.util.*;

public class p10217
{
    static class Airport
        implements Comparable
    {

        public int compareTo(Airport o)
        {
            if(time < o.time)
                return -1;
            if(time == o.time)
                return money >= o.money ? 0 : -1;
            else
                return 1;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((Airport)obj);
        }

        int number;
        int money;
        int time;

        Airport(int number, int money, int time)
        {
            this.number = number;
            this.time = time;
            this.money = money;
        }
    }


    public p10217()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.valueOf(st.nextToken()).intValue();
        StringBuilder sb = new StringBuilder();
        while(tc-- > 0) 
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.valueOf(st.nextToken()).intValue();
            int m = Integer.valueOf(st.nextToken()).intValue();
            int k = Integer.valueOf(st.nextToken()).intValue();
            moneyDp = new int[n + 1][m + 1];
            graph = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++)
            {
                graph[i] = new ArrayList();
                Arrays.fill(moneyDp[i], 0x3fffffff);
            }

            for(int i = 0; i < k; i++)
            {
                st = new StringTokenizer(br.readLine());
                int u = Integer.valueOf(st.nextToken()).intValue();
                int v = Integer.valueOf(st.nextToken()).intValue();
                int c = Integer.valueOf(st.nextToken()).intValue();
                int d = Integer.valueOf(st.nextToken()).intValue();
                graph[u].add(new Airport(v, c, d));
            }

            dijkstra(n, m, 1);
            int min = 0x3fffffff;
            for(int i = 0; i <= m; i++)
                min = Math.min(min, moneyDp[n][i]);

            if(min == 0x3fffffff)
                sb.append("Poor KCM");
            else
                sb.append(min);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dijkstra(int n, int m, int start)
    {
        PriorityQueue pq = new PriorityQueue();
        pq.offer(new Airport(start, 0, 0));
        moneyDp[start][0] = 0;
        while(!pq.isEmpty()) 
        {
            Airport airport = (Airport)pq.poll();
            int nowAirport = airport.number;
            int nowMoney = airport.money;
            int nowTime = airport.time;
            if(nowAirport == n)
                break;
            for(Iterator iterator = graph[nowAirport].iterator(); iterator.hasNext();)
            {
                Airport air = (Airport)iterator.next();
                int nextNum = air.number;
                int nextMoney = air.money + nowMoney;
                int nextTime = air.time + nowTime;
                if(nextMoney <= m && moneyDp[nextNum][nextMoney] > nextTime)
                {
                    for(int j = nextMoney; j <= m; j++)
                        if(moneyDp[nextNum][j] > nextTime)
                            moneyDp[nextNum][j] = nextTime;

                    pq.offer(new Airport(air.number, nextMoney, nextTime));
                }
            }

        }
    }

    static List graph[];
    static int moneyDp[][];
    static final int INF = 0x3fffffff;
}
