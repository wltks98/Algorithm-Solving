// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p3584.java

import java.io.*;
import java.util.*;

public class p3584
{

    public p3584()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++)
        {
            N = Integer.parseInt(br.readLine());
            nodes = new HashMap();
            parentList = new ArrayList();
            StringTokenizer st;
            for(int j = 0; j < N - 1; j++)
            {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                if(!nodes.containsKey(Integer.valueOf(parent)))
                    nodes.put(Integer.valueOf(parent), Integer.valueOf(-1));
                if(!nodes.containsKey(Integer.valueOf(child)))
                    nodes.put(Integer.valueOf(child), Integer.valueOf(parent));
                else
                    nodes.replace(Integer.valueOf(child), Integer.valueOf(-1), Integer.valueOf(parent));
            }

            st = new StringTokenizer(br.readLine());
            targetA = Integer.parseInt(st.nextToken());
            targetB = Integer.parseInt(st.nextToken());
            GetParent(targetA);
            CompareParent(targetB);
        }

        int s;
        for(Iterator iterator = answerList.iterator(); iterator.hasNext(); System.out.println(s))
            s = ((Integer)iterator.next()).intValue();

    }

    public static void GetParent(int A)
    {
        parentList.add(Integer.valueOf(A));
        int parentA = ((Integer)nodes.get(Integer.valueOf(A))).intValue();
        if(parentA != -1)
            GetParent(parentA);
    }

    public static void CompareParent(int B)
    {
        if(parentList.contains(Integer.valueOf(B)))
        {
            answerList.add(Integer.valueOf(B));
            return;
        } else
        {
            CompareParent(((Integer)nodes.get(Integer.valueOf(B))).intValue());
            return;
        }
    }

    static int T;
    static int N;
    static int targetA;
    static int targetB;
    static ArrayList parentList;
    static HashMap nodes;
    static ArrayList answerList = new ArrayList();

}
