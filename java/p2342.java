// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2342.java

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2342
{

    public p2342()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        set();
        solve();
        bw.flush();
        br.close();
        bw.close();
    }

    static void set()
        throws IOException
    {
        StringTokenizer st = new StringTokenizer(br.readLine());
        do
        {
            int k = Integer.parseInt(st.nextToken());
            if(k != 0)
            {
                map.add(Integer.valueOf(k));
            } else
            {
                dp = new int[map.size()][5][5];
                return;
            }
        } while(true);
    }

    static void solve()
        throws IOException
    {
        bw.write((new StringBuilder(String.valueOf(dfs(0, 0, 0)))).toString());
    }

    static int dfs(int x, int left, int right)
    {
        if(x == map.size())
            return 0;
        if(dp[x][left][right] != 0)
        {
            return dp[x][left][right];
        } else
        {
            int goLeft = dfs(x + 1, ((Integer)map.get(x)).intValue(), right) + going(left, ((Integer)map.get(x)).intValue());
            int goRight = dfs(x + 1, left, ((Integer)map.get(x)).intValue()) + going(right, ((Integer)map.get(x)).intValue());
            return dp[x][left][right] = Math.min(goLeft, goRight);
        }
    }

    static int going(int go, int to)
    {
        if(go == 0)
            return 2;
        if(Math.abs(go - to) == 2)
            return 4;
        return go != to ? 3 : 1;
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static int dp[][][];
    static ArrayList map = new ArrayList();

    static 
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
