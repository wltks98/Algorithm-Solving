// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p9466.java

import java.io.PrintStream;
import java.util.Scanner;

public class p9466
{

    public p9466()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        for(int t = scan.nextInt(); t-- > 0;)
        {
            int n = scan.nextInt();
            cnt = 0;
            arr = new int[n + 1];
            visit = new boolean[n + 1];
            done = new boolean[n + 1];
            for(int i = 1; i <= n; i++)
                arr[i] = scan.nextInt();

            for(int i = 1; i <= n; i++)
                if(!done[i])
                    dfs(i);

            System.out.println(n - cnt);
        }

    }

    private static void dfs(int v)
    {
        if(visit[v])
        {
            done[v] = true;
            cnt++;
        } else
        {
            visit[v] = true;
        }
        if(!done[arr[v]])
            dfs(arr[v]);
        visit[v] = false;
        done[v] = true;
    }

    static int arr[];
    static boolean visit[];
    static boolean done[];
    static int cnt;
}
