// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11054.java

import java.io.PrintStream;
import java.util.Scanner;

public class p11054
{

    public p11054()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n + 1];
        int num[] = new int[n + 1];
        int answer = 0;
        for(int i = 1; i <= n; i++)
            num[i] = sc.nextInt();

        dp[1] = 1;
        if(n < 2)
        {
            System.out.println(dp[1]);
            return;
        }
        for(int i = 2; i <= n; i++)
        {
            int max = 0;
            for(int j = 1; j < i; j++)
                if(max < dp[j] && num[i] > num[j])
                    max = dp[j];

            dp[i] = max + 1;
        }

        for(int i = 1; i <= n; i++)
        {
            int max2 = 0;
            for(int j = i + 1; j <= n; j++)
            {
                int m = dp[i];
                int top = num[i];
                for(int k = j; k <= n; k++)
                    if(top > num[k])
                    {
                        top = num[k];
                        m++;
                    }

                if(max2 < m)
                    max2 = m;
            }

            if(i != n)
                dp[i] = max2;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
