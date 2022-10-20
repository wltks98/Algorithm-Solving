// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p10989.java

import java.io.*;

public class p10989
{

    public p10989()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        br.close();
        int counting[] = new int[10001];
        int result[] = new int[n];
        for(int i = 0; i < n; i++)
            counting[arr[i]]++;

        for(int i = 2; i < 10001; i++)
            counting[i] += counting[i - 1];

        for(int i = n - 1; i >= 0; i--)
            result[--counting[arr[i]]] = arr[i];

        int ai[];
        int k = (ai = result).length;
        for(int j = 0; j < k; j++)
        {
            int num = ai[j];
            sb.append(num).append('\n');
        }

        System.out.print(sb);
    }
}
