// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2473.java

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2473
{

    public p2473()
    {
    }

    static int stoi(String s)
    {
        return Integer.parseInt(s);
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        long arr[] = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);
        for(int i = 0; i < n - 2; i++)
            solution(arr, i);

        Arrays.sort(pick);
        for(int i = 0; i < 3; i++)
            System.out.print((new StringBuilder(String.valueOf(pick[i]))).append(" ").toString());

    }

    static void solution(long arr[], int index)
    {
        int left = index + 1;
        for(int right = arr.length - 1; left < right;)
        {
            long sum = arr[left] + arr[right] + arr[index];
            long absSum = Math.abs(sum);
            if(absSum < max)
            {
                pick[0] = arr[left];
                pick[1] = arr[right];
                pick[2] = arr[index];
                max = absSum;
            }
            if(sum > 0L)
                right--;
            else
                left++;
        }

    }

    static long pick[] = new long[3];
    static long max = 0xb2d05e00L;

}
