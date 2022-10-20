// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1509.java

import java.io.*;

public class p1509
{

    public p1509()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int len = str.length();
        palindrome = new boolean[len + 1][len + 1];
        dp = new int[len + 1];
        for(int i = 1; i <= len; i++)
            dp[i] = 0x7fffffff;

        checkPalindrome(str, len);
        for(int i = 1; i <= len; i++)
        {
            for(int j = 1; j <= i; j++)
                if(palindrome[j][i])
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);

        }

        bw.write((new StringBuilder(String.valueOf(dp[len]))).append("\n").toString());
        bw.flush();
    }

    public static void checkPalindrome(String str, int len)
    {
        for(int start = 1; start <= len; start++)
        {
            for(int end = start; end <= len; end++)
            {
                boolean flag = true;
                int s = start - 1;
                for(int e = end - 1; s <= e;)
                    if(str.charAt(s++) != str.charAt(e--))
                    {
                        flag = false;
                        break;
                    }

                if(flag)
                    palindrome[start][end] = true;
            }

        }

    }

    static boolean palindrome[][];
    static int dp[];
}
