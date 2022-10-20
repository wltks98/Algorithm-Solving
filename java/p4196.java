// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p4196.java

import java.io.PrintStream;
import java.util.*;

public class p4196
{

    public p4196()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int caseSize = scan.nextInt();
        for(int i = 0; i < caseSize; i++)
        {
            int N = scan.nextInt();
            int M = scan.nextInt();
            array = new ArrayList[N + 1];
            sccGroup = new ArrayList[N + 1];
            for(int j = 0; j < N + 1; j++)
            {
                array[j] = new ArrayList();
                sccGroup[j] = new ArrayList();
            }

            for(int j = 0; j < M; j++)
            {
                int startIndex = scan.nextInt();
                int endIndex = scan.nextInt();
                array[startIndex].add(Integer.valueOf(endIndex));
            }

            mySccGroup = new int[N + 1];
            order = new int[N + 1];
            visited = new boolean[N + 1];
            size = num = 0;
            for(int j = 1; j < N + 1; j++)
                if(order[j] == 0)
                    SCC(j);

            boolean indegree[] = new boolean[size];
            for(int j = 1; j < N + 1; j++)
            {
                for(int k = 0; k < array[j].size(); k++)
                {
                    int endNode = ((Integer)array[j].get(k)).intValue();
                    if(mySccGroup[endNode] != mySccGroup[j])
                        indegree[mySccGroup[endNode]] = true;
                }

            }

            int count = 0;
            for(int j = 0; j < size; j++)
                if(!indegree[j])
                    count++;

            System.out.println(count);
            System.out.println(Arrays.toString(order));
        }

    }

    public static int SCC(int index)
    {
        order[index] = ++num;
        stack.add(Integer.valueOf(index));
        int parent = order[index];
        for(int i = 0; i < array[index].size(); i++)
        {
            int temp = ((Integer)array[index].get(i)).intValue();
            if(order[temp] == 0)
                parent = Math.min(parent, SCC(temp));
            else
            if(!visited[temp])
                parent = Math.min(parent, order[temp]);
        }

        if(parent == order[index])
        {
            int top;
            do
            {
                top = ((Integer)stack.pop()).intValue();
                visited[top] = true;
                sccGroup[size].add(Integer.valueOf(top));
                mySccGroup[top] = size;
            } while(top != index);
            size++;
        }
        return parent;
    }

    static ArrayList array[];
    static ArrayList sccGroup[];
    static int order[];
    static int num;
    static int size;
    static Stack stack = new Stack();
    static boolean visited[];
    static int mySccGroup[];

}
