// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1007.java

import java.io.PrintStream;
import java.util.Scanner;

public class p1007
{

    public p1007()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for(int tc = 1; tc <= t; tc++)
        {
            n = in.nextInt();
            ans = 1.7976931348623157E+308D;
            for(int i = 0; i < n; i++)
            {
                ax[i] = in.nextInt();
                ay[i] = in.nextInt();
            }

            go(0, 0);
            System.out.printf("%.6f\n", new Object[] {
                Double.valueOf(ans)
            });
        }

        in.close();
    }

    static void go(int cnt, int index)
    {
        if(cnt == n / 2)
        {
            double x = 0.0D;
            double y = 0.0D;
            for(int i = 0; i < n; i++)
                if(c[i])
                {
                    x -= ax[i];
                    y -= ay[i];
                } else
                {
                    x += ax[i];
                    y += ay[i];
                }

            ans = Math.min(ans, Math.sqrt(x * x + y * y));
            return;
        }
        if(index == n)
        {
            return;
        } else
        {
            go(cnt, index + 1);
            c[index] = true;
            go(cnt + 1, index + 1);
            c[index] = false;
            return;
        }
    }

    static double ans;
    static int n;
    static int t;
    static int ax[] = new int[21];
    static int ay[] = new int[21];
    static boolean c[] = new boolean[21];

}
