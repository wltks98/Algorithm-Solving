// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2263.java

import java.io.*;
import java.util.StringTokenizer;

public class p2263
{

    public p2263()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        N = Integer.parseInt(br.readLine());
        inOrder = new int[N + 1];
        postOrder = new int[N + 1];
        pos = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
        {
            inOrder[i] = Integer.parseInt(st.nextToken());
            pos[inOrder[i]] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            postOrder[i] = Integer.parseInt(st.nextToken());

        preOrder(1, N, 1, N);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void preOrder(int inLeft, int inRight, int postLeft, int postRight)
        throws IOException
    {
        if(inLeft > inRight || postLeft > postRight)
        {
            return;
        } else
        {
            bw.write((new StringBuilder(String.valueOf(postOrder[postRight]))).append(" ").toString());
            int idx = pos[postOrder[postRight]];
            int leftCnt = idx - inLeft;
            preOrder(inLeft, idx - 1, postLeft, (postLeft + leftCnt) - 1);
            preOrder(idx + 1, inRight, postLeft + leftCnt, postRight - 1);
            return;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int inOrder[];
    static int postOrder[];
    static int pos[];

    static 
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
