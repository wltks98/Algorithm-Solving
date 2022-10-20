// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p6549.java

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class p6549
{

    public p6549()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        do
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            if(N != 0)
            {
                histogram = new int[N];
                for(int i = 0; i < N; i++)
                    histogram[i] = Integer.parseInt(st.nextToken());

                sb.append(getArea(N)).append('\n');
                histogram = null;
            } else
            {
                System.out.println(sb);
                return;
            }
        } while(true);
    }

    public static long getArea(int len)
    {
        Stack stack = new Stack();
        long maxArea = 0L;
        for(int i = 0; i < len; i++)
        {
            while(!stack.isEmpty() && histogram[((Integer)stack.peek()).intValue()] >= histogram[i]) 
            {
                int height = histogram[((Integer)stack.pop()).intValue()];
                long width = stack.isEmpty() ? i : i - 1 - ((Integer)stack.peek()).intValue();
                maxArea = Math.max(maxArea, (long)height * width);
            }
            stack.push(Integer.valueOf(i));
        }

        while(!stack.isEmpty()) 
        {
            int height = histogram[((Integer)stack.pop()).intValue()];
            long width = stack.isEmpty() ? len : len - 1 - ((Integer)stack.peek()).intValue();
            maxArea = Math.max(maxArea, width * (long)height);
        }
        return maxArea;
    }

    public static int histogram[];
}
