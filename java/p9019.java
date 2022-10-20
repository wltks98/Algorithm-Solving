// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p9019.java

import java.io.PrintStream;
import java.util.*;

public class p9019
{

    public p9019()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String command[] = new String[10000];
            boolean visited[] = new boolean[10000];
            Queue q = new LinkedList();
            visited[a] = true;
            q.add(Integer.valueOf(a));
            Arrays.fill(command, "");
            while(!q.isEmpty() && !visited[b]) 
            {
                int now = ((Integer)q.poll()).intValue();
                int D = (2 * now) % 10000;
                int S = now != 0 ? now - 1 : 9999;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;
                if(!visited[D])
                {
                    q.add(Integer.valueOf(D));
                    visited[D] = true;
                    command[D] = (new StringBuilder(String.valueOf(command[now]))).append("D").toString();
                }
                if(!visited[S])
                {
                    q.add(Integer.valueOf(S));
                    visited[S] = true;
                    command[S] = (new StringBuilder(String.valueOf(command[now]))).append("S").toString();
                }
                if(!visited[L])
                {
                    q.add(Integer.valueOf(L));
                    visited[L] = true;
                    command[L] = (new StringBuilder(String.valueOf(command[now]))).append("L").toString();
                }
                if(!visited[R])
                {
                    q.add(Integer.valueOf(R));
                    visited[R] = true;
                    command[R] = (new StringBuilder(String.valueOf(command[now]))).append("R").toString();
                }
            }
            System.out.println(command[b]);
        }

    }
}
