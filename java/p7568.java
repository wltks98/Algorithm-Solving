// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p7568.java

import java.io.PrintStream;
import java.util.Scanner;

public class p7568
{

    public p7568()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int name[][] = new int[n][3];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 2; j++)
                name[i][j] = sc.nextInt();

            name[i][2] = n;
        }

        for(int i = 0; i < n; i++)
        {
            int grade = 1;
            for(int j = 0; j < n; j++)
                if(name[i][0] < name[j][0] && name[i][1] < name[j][1])
                    grade++;

            name[i][2] = grade;
        }

        for(int i = 0; i < n; i++)
            System.out.print((new StringBuilder(String.valueOf(name[i][2]))).append(" ").toString());

    }
}
