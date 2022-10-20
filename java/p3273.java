// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p3273.java

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3273
{

    public p3273()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int start = 0;
        int end = N - 1;
        int sum = 0;
        int result = 0;
        while(start < end) 
        {
            sum = arr[start] + arr[end];
            if(sum == x)
                result++;
            if(sum <= x)
                start++;
            else
                end--;
        }
        bw.write((new StringBuilder(String.valueOf(result))).append("\n").toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
