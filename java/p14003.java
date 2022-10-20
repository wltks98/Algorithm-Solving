// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p14003.java

import java.io.*;
import java.util.*;

public class p14003
{

    public p14003()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List list = new ArrayList();
        int arr[] = new int[n + 1];
        int indexArr[] = new int[n + 1];
        for(int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        list.add(Integer.valueOf(0x80000000));
        for(int i = 1; i <= n; i++)
        {
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;
            if(num > ((Integer)list.get(list.size() - 1)).intValue())
            {
                list.add(Integer.valueOf(num));
                indexArr[i] = list.size() - 1;
            } else
            {
                while(left < right) 
                {
                    int mid = left + right >> 1;
                    if(((Integer)list.get(mid)).intValue() >= num)
                        right = mid;
                    else
                        left = mid + 1;
                }
                list.set(right, Integer.valueOf(num));
                indexArr[i] = right;
            }
        }

        sb.append((new StringBuilder(String.valueOf(list.size() - 1))).append("\n").toString());
        Stack stack = new Stack();
        int index = list.size() - 1;
        for(int i = n; i > 0; i--)
            if(indexArr[i] == index)
            {
                index--;
                stack.push(Integer.valueOf(arr[i]));
            }

        for(; !stack.isEmpty(); sb.append((new StringBuilder()).append(stack.pop()).append(" ").toString()));
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static final BufferedReader br;
    private static final BufferedWriter bw;
    static StringBuilder sb = new StringBuilder();

    static 
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
}
