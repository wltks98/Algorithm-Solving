// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1644.java

import java.io.*;
import java.util.ArrayList;

public class p1644
{

    public p1644()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        prime = new boolean[N + 1];
        prime[0] = prime[1] = true;
        for(int i = 2; i * i <= N; i++)
            if(!prime[i])
            {
                for(int j = i * i; j <= N; j += i)
                    prime[j] = true;

            }

        for(int i = 1; i <= N; i++)
            if(!prime[i])
                prime_numbers.add(Integer.valueOf(i));

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        do
        {
            if(sum >= N)
            {
                sum -= ((Integer)prime_numbers.get(start++)).intValue();
            } else
            {
                if(end == prime_numbers.size())
                    break;
                sum += ((Integer)prime_numbers.get(end++)).intValue();
            }
            if(N == sum)
                count++;
        } while(true);
        System.out.println(count);
    }

    static boolean prime[];
    static ArrayList prime_numbers = new ArrayList();

}
