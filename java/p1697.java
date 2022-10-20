// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1697.java

import java.io.PrintStream;
import java.util.*;

public class p1697
{

    public p1697()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int Min[] = new int[0x186a5];
        Arrays.fill(Min, -1);
        System.out.println(BFS(N, K, Min));
    }

    public static int BFS(int N, int K, int Min[])
    {
        int nextN = N;
        int status[] = new int[3];
        Queue q = new LinkedList();
        q.add(Integer.valueOf(nextN));
        Min[nextN] = 0;
        while(!q.isEmpty() && nextN != K) 
        {
            nextN = ((Integer)q.poll()).intValue();
            status[0] = nextN - 1;
            status[1] = nextN + 1;
            status[2] = nextN * 2;
            for(int i = 0; i < 3; i++)
                if(status[i] >= 0 && status[i] <= 0x186a0 && Min[status[i]] == -1)
                {
                    q.add(Integer.valueOf(status[i]));
                    Min[status[i]] = Min[nextN] + 1;
                }

        }
        return Min[K];
    }
}
