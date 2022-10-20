// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2565.java

import java.io.PrintStream;
import java.util.*;

public class p2565
{

    public p2565()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num[][] = new int[n + 1][2];
        int dp[] = new int[n + 1];
        int maxInstall = 1;
        for(int i = 1; i <= n; i++)
        {
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
        }

        Arrays.sort(num, new Comparator() {

            public int compare(int o1[], int o2[])
            {
                return o1[0] - o2[0];
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((int[])obj, (int[])obj1);
            }

        }
);
        for(int i = 1; i <= n; i++)
        {
            dp[i] = 1;
            for(int j = 1; j < i; j++)
                if(num[j][1] < num[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);

            maxInstall = Math.max(maxInstall, dp[i]);
        }

        System.out.println(n - maxInstall);
    }
}
