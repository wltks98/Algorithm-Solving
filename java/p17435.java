// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p17435.java

import java.io.*;
import java.util.StringTokenizer;

public class p17435
{

    public p17435()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int parent[][] = new int[19][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < N + 1; i++)
            parent[0][i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < 19; i++)
        {
            for(int j = 1; j < N + 1; j++)
                parent[i][j] = parent[i - 1][parent[i - 1][j]];

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int Q = Integer.parseInt(br.readLine()); Q-- > 0;)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for(int i = 18; i > -1; i--)
            {
                int cur = 1 << i;
                if(n < cur)
                    continue;
                x = parent[i][x];
                n -= cur;
                if(n == 0)
                    break;
            }

            bw.write((new StringBuilder(String.valueOf(x))).append("\n").toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static final int log = 18;
}
