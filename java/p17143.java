// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p17143.java

import java.io.*;
import java.util.*;

public class p17143
{
    static class Shark
    {

        int x;
        int y;
        int speed;
        int dir;
        int size;

        Shark()
        {
        }
    }


    public p17143()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        if(m == 0)
        {
            System.out.println(0);
            return;
        }
        map = new int[r + 1][c + 1];
        for(int i = 0; i < m; i++)
        {
            st = new StringTokenizer(reader.readLine());
            Shark shark = new Shark();
            shark.x = Integer.parseInt(st.nextToken());
            shark.y = Integer.parseInt(st.nextToken());
            shark.speed = Integer.parseInt(st.nextToken());
            shark.dir = Integer.parseInt(st.nextToken());
            shark.size = Integer.parseInt(st.nextToken());
            int cases = 0;
            if(shark.dir <= 2)
                cases = (r - 1) * 2;
            else
                cases = (c - 1) * 2;
            if(cases >= shark.speed)
                shark.speed %= cases;
            map[shark.x][shark.y] = shark.size;
            sharks.put(Integer.valueOf(shark.size), shark);
        }

        for(int y = 1; y <= c; y++)
        {
            fishShark(y);
            moveShark();
        }

        System.out.println(result);
    }

    private static void fishShark(int y)
    {
        for(int x = 1; x <= r; x++)
            if(map[x][y] != 0)
            {
                result += map[x][y];
                sharks.remove(Integer.valueOf(map[x][y]));
                map[x][y] = 0;
                return;
            }

    }

    private static void moveShark()
    {
        int temp[][] = new int[r + 1][c + 1];
        Queue failer = new LinkedList();
        for(Iterator iterator = sharks.keySet().iterator(); iterator.hasNext();)
        {
            Integer key = (Integer)iterator.next();
            Shark shark = (Shark)sharks.get(key);
            map[shark.x][shark.y] = 0;
            for(int i = 0; i < shark.speed; i++)
            {
                if(shark.dir == 1 && shark.x == 1)
                    shark.dir = 2;
                else
                if(shark.dir == 2 && shark.x == r)
                    shark.dir = 1;
                else
                if(shark.dir == 3 && shark.y == c)
                    shark.dir = 4;
                else
                if(shark.dir == 4 && shark.y == 1)
                    shark.dir = 3;
                shark.x += dx[shark.dir];
                shark.y += dy[shark.dir];
            }

            if(temp[shark.x][shark.y] == 0)
                temp[shark.x][shark.y] = shark.size;
            else
            if(temp[shark.x][shark.y] < shark.size)
            {
                failer.add(Integer.valueOf(temp[shark.x][shark.y]));
                temp[shark.x][shark.y] = shark.size;
            } else
            {
                failer.add(Integer.valueOf(shark.size));
            }
        }

        for(; !failer.isEmpty(); sharks.remove(failer.poll()));
        for(Iterator iterator1 = sharks.keySet().iterator(); iterator1.hasNext();)
        {
            Integer key = (Integer)iterator1.next();
            Shark shark = (Shark)sharks.get(key);
            map[shark.x][shark.y] = temp[shark.x][shark.y];
        }

    }

    private static int r;
    private static int c;
    private static int m;
    private static int map[][];
    private static int dx[] = {
        0, -1, 1, 0, 0
    };
    private static int dy[] = {
        0, 0, 0, 1, -1
    };
    private static HashMap sharks = new HashMap();
    private static int result = 0;

}
