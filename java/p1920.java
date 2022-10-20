// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1920.java

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class p1920
{

    public p1920()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A[] = new int[n];
        for(int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        Arrays.sort(A);
        int m = sc.nextInt();
        for(int i = 0; i < m; i++)
        {
            int num = sc.nextInt();
            int left = 0;
            int right = A.length - 1;
            boolean flag = false;
            while(left <= right) 
            {
                int midIndex = (left + right) / 2;
                int midValue = A[midIndex];
                if(midValue > num)
                {
                    right = midIndex - 1;
                    continue;
                }
                if(midValue < num)
                {
                    left = midIndex + 1;
                    continue;
                }
                flag = true;
                System.out.println(1);
                break;
            }
            if(!flag)
                System.out.println(0);
        }

    }
}
