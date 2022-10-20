// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p3665.java

import java.io.PrintStream;
import java.util.*;

public class p3665
{

    public p3665()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int time = 1; time <= T; time++)
        {
            int N = sc.nextInt();
            int inDegree[] = new int[N + 1];
            int array[] = new int[N + 1];
            for(int i = 1; i <= N; i++)
                array[i] = sc.nextInt();

            List list[] = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++)
                list[i] = new ArrayList();

            for(int i = 1; i <= N; i++)
            {
                int from = array[i];
                for(int j = i + 1; j <= N; j++)
                {
                    list[from].add(Integer.valueOf(array[j]));
                    inDegree[array[j]]++;
                }

            }

            int M = sc.nextInt();
            for(int i = 0; i < M; i++)
            {
                int front = sc.nextInt();
                int back = sc.nextInt();
                if(list[front].contains(Integer.valueOf(back)))
                {
                    list[front].remove(Integer.valueOf(back));
                    list[back].add(Integer.valueOf(front));
                    inDegree[front]++;
                    inDegree[back]--;
                } else
                {
                    list[back].remove(Integer.valueOf(front));
                    list[front].add(Integer.valueOf(back));
                    inDegree[back]++;
                    inDegree[front]--;
                }
            }

            StringBuilder sb = new StringBuilder();
            Queue queue = new LinkedList();
            int cnt = 0;
            for(int i = 1; i <= N; i++)
                if(inDegree[i] == 0)
                {
                    cnt++;
                    queue.add(Integer.valueOf(i));
                }

            if(cnt > 1)
            {
                System.out.println("?");
            } else
            {
                boolean isFinished = false;
                for(int i = 1; i <= N; i++)
                {
                    if(queue.isEmpty())
                    {
                        System.out.println("IMPOSSIBLE");
                        isFinished = true;
                        break;
                    }
                    int from = ((Integer)queue.poll()).intValue();
                    sb.append(from).append(" ");
                    for(Iterator iterator = list[from].iterator(); iterator.hasNext();)
                    {
                        int to = ((Integer)iterator.next()).intValue();
                        inDegree[to]--;
                        if(inDegree[to] == 0)
                            queue.add(Integer.valueOf(to));
                    }

                }

                if(!isFinished)
                    System.out.println(sb.toString());
            }
        }

    }
}
