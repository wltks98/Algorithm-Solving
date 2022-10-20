// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1931.java

import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class p1931
{

    public p1931()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator() {

            public int compare(int o1[], int o2[])
            {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((int[])obj, (int[])obj1);
            }

        }
);
        int count = 0;
        int end = 0;
        for(int i = 0; i < n; i++)
            if(arr[i][0] >= end)
            {
                end = arr[i][1];
                count++;
            }

        System.out.println(count);
    }
}
