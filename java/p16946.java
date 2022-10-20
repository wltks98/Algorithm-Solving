// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p16946.java

import java.io.*;
import java.util.*;

public class p16946
{
    static class Point
    {

        int x;
        int y;

        Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }


    public p16946()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        group = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            String str[] = br.readLine().split("");
            for(int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(str[j]);

        }

        int groupCnt = 1;
        groupSize = new HashMap();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                if(arr[i][j] == 0 && group[i][j] == 0)
                {
                    groupSize.put(Integer.valueOf(groupCnt), Integer.valueOf(bfs(i, j, groupCnt)));
                    groupCnt++;
                }

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                if(group[i][j] == 0)
                    sb.append((new StringBuilder(String.valueOf(count(i, j)))).toString());
                else
                    sb.append("0");

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int count(int x, int y)
    {
        int cnt = 1;
        if(arr[x][y] == 0)
            return 0;
        Set set = new HashSet();
        for(int i = 0; i < 4; i++)
        {
            int dx[] = {
                0, 1, 0, -1
            };
            int dy[] = {
                1, 0, -1, 0
            };
            int sx = x + dx[i];
            int sy = y + dy[i];
            if(sx >= 0 && sy >= 0 && sx < n && sy < m && group[sx][sy] != 0)
                set.add(Integer.valueOf(group[sx][sy]));
        }

        for(Iterator iterator = set.iterator(); iterator.hasNext();)
        {
            int size = ((Integer)iterator.next()).intValue();
            cnt += ((Integer)groupSize.get(Integer.valueOf(size))).intValue();
        }

        return cnt % 10;
    }

    static int bfs(int x, int y, int groupCnt)
    {
        int cnt = 1;
        Queue q = new LinkedList();
        q.add(new Point(x, y));
        group[x][y] = groupCnt;
        while(!q.isEmpty()) 
        {
            Point point = (Point)q.poll();
            int dx[] = {
                0, 1, 0, -1
            };
            int dy[] = {
                1, 0, -1, 0
            };
            for(int i = 0; i < 4; i++)
            {
                int sx = point.x + dx[i];
                int sy = point.y + dy[i];
                if(sx >= 0 && sy >= 0 && sx < n && sy < m && group[sx][sy] == 0 && arr[sx][sy] == 0)
                {
                    group[sx][sy] = groupCnt;
                    cnt++;
                    q.add(new Point(sx, sy));
                }
            }

        }
        return cnt;
    }

    static int arr[][];
    static int group[][];
    static int n;
    static int m;
    static Map groupSize;
}
