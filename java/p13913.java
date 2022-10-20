// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p13913.java

import java.io.PrintStream;
import java.util.*;

public class p13913
{

    public p13913()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int N = sc.nextInt();
        int K = sc.nextInt();
        Arrays.fill(Min, -1);
        System.out.println(BFS(N, K));
        int i = K;
        Stack stack = new Stack();
        stack.add(Integer.valueOf(K));
        for(; i != N; i = parent[i])
            stack.add(Integer.valueOf(parent[i]));

        for(; !stack.isEmpty(); System.out.print((new StringBuilder()).append(stack.pop()).append(" ").toString()));
    }

    public static int BFS(int N, int K)
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
                    parent[status[i]] = nextN;
                    q.add(Integer.valueOf(status[i]));
                    Min[status[i]] = Min[nextN] + 1;
                }

        }
        return Min[K];
    }

    static int Min[] = new int[0x186a5];
    static int parent[] = new int[0x186a5];

}
