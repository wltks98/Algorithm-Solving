// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1806.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1806
{

    public p1806()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N];
        for(int i = 0; i < N; i++)
            nums[i] = sc.nextInt();

        do
        {
            while(sum >= S) 
            {
                sum -= nums[left];
                answer = Math.min(answer, right - left);
                left++;
            }
            if(right == N)
                break;
            sum += nums[right++];
        } while(true);
        if(answer == 0x186a1)
            System.out.println(0);
        else
            System.out.println(answer);
    }

    private static int N;
    private static int S;
    private static int left = 0;
    private static int right = 0;
    private static int answer = 0x186a1;
    private static int sum = 0;
    private static int nums[];

}
