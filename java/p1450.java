// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1450.java

import java.io.*;
import java.util.*;

public class p1450
{

    public p1450()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        ArrayList left = new ArrayList();
        ArrayList right = new ArrayList();
        dfs(0, n / 2, 0, left);
        dfs(n / 2 + 1, n - 1, 0, right);
        Collections.sort(left);
        Collections.sort(right);
        int ans = 0;
        int e = right.size() - 1;
        for(int i = 0; i < left.size(); i++)
        {
            while(e >= 0 && ((Integer)left.get(i)).intValue() + ((Integer)right.get(e)).intValue() > c) 
                e--;
            ans += e + 1;
        }

        System.out.println(ans);
    }

    public static void dfs(int cur, int end, int sum, ArrayList list)
    {
        if(sum > c)
            return;
        if(cur > end)
        {
            list.add(Integer.valueOf(sum));
            return;
        } else
        {
            dfs(cur + 1, end, sum, list);
            dfs(cur + 1, end, sum + arr[cur], list);
            return;
        }
    }

    public static int n;
    public static int c;
    public static int arr[];
}
