// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1021.java

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class p1021
{

    public p1021()
    {
    }

    public static void main(String args[])
    {
        ArrayList list = new ArrayList();
        int cnt = 0;
        int idx = 0;
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int arr[] = new int[M];
        for(int i = 0; i < M; i++)
            arr[i] = scan.nextInt();

        for(int i = 1; i <= N; i++)
            list.add(Integer.valueOf(i));

        for(; M > 0; M--)
        {
            do
            {
                if(((Integer)list.get(0)).intValue() == arr[idx])
                {
                    list.remove(0);
                    break;
                }
                if(list.indexOf(Integer.valueOf(arr[idx])) <= list.size() / 2)
                    list.add(list.size() - 1, (Integer)list.remove(0));
                else
                    list.add(0, (Integer)list.remove(list.size() - 1));
                cnt++;
            } while(true);
            idx++;
        }

        System.out.println(cnt);
    }
}
