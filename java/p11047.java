// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p11047.java

import java.io.PrintStream;
import java.util.*;

public class p11047
{

    public p11047()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int kk = k;
        int a = 0;
        int count = 0;
        int coin[] = new int[n];
        int coin2[] = new int[n];
        ArrayList list = new ArrayList();
        for(int i = 0; i < n; i++)
            coin[i] = sc.nextInt();

        for(int i = 0; i < n; i++)
            list.add(Integer.valueOf(coin[i]));

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.get(0));
        for(int i = 0; i < a; i++)
        {
            if((k / ((Integer)list.get(i)).intValue()) * ((Integer)list.get(i)).intValue() > k)
                continue;
            if((k / ((Integer)list.get(i)).intValue()) * ((Integer)list.get(i)).intValue() == k)
            {
                count += k / ((Integer)list.get(i)).intValue();
                break;
            }
            count += k / ((Integer)list.get(i)).intValue();
            k -= (k / ((Integer)list.get(i)).intValue()) * ((Integer)list.get(i)).intValue();
        }

        System.out.println(count);
    }
}
