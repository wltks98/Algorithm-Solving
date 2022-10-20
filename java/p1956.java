// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1956.java

import java.io.*;
import java.util.StringTokenizer;

public class p1956
{

    public p1956()
    {
    }

    public static void main(String args[])
        throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int arr[][] = new int[V + 1][V + 1];
        for(int i = 1; i <= V; i++)
        {
            for(int j = 1; j <= V; j++)
                if(i != j)
                    arr[i][j] = 0x3ade68b1;

        }

        for(int i = 0; i < E; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        for(int k = 1; k <= V; k++)
        {
            for(int i = 1; i <= V; i++)
            {
                for(int j = 1; j <= V; j++)
                    if(i != j && arr[i][j] > arr[i][k] + arr[k][j])
                        arr[i][j] = arr[i][k] + arr[k][j];

            }

        }

        int ans = 0x3ade68b1;
        for(int i = 1; i <= V; i++)
        {
            for(int j = 1; j <= V; j++)
                if(i != j && arr[i][j] != 0x3ade68b1 && arr[j][i] != 0x3ade68b1)
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);

        }

        ans = ans != 0x3ade68b1 ? ans : -1;
        bw.write((new StringBuilder(String.valueOf(ans))).append("\n").toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static final int INF = 0x3ade68b1;
}
