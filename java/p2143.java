// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2143.java

import java.io.*;
import java.util.*;

public class p2143
{

    public p2143()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        sumA = new ArrayList();
        for(int i = 0; i < N; i++)
        {
            int tmp = A[i];
            sumA.add(Integer.valueOf(tmp));
            for(int j = i + 1; j < N; j++)
            {
                tmp += A[j];
                sumA.add(Integer.valueOf(tmp));
            }

        }

        sumB = new ArrayList();
        for(int i = 0; i < M; i++)
        {
            int tmp = B[i];
            sumB.add(Integer.valueOf(tmp));
            for(int j = i + 1; j < M; j++)
            {
                tmp += B[j];
                sumB.add(Integer.valueOf(tmp));
            }

        }

        sumA.sort(new Comparator() {

            public int compare(Integer o1, Integer o2)
            {
                return o1.intValue() - o2.intValue();
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Integer)obj, (Integer)obj1);
            }

        }
);
        sumB.sort(new Comparator() {

            public int compare(Integer o1, Integer o2)
            {
                return o1.intValue() - o2.intValue();
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((Integer)obj, (Integer)obj1);
            }

        }
);
        int sumASize = sumA.size();
        int sumBSize = sumB.size();
        ap = 0;
        bp = sumBSize - 1;
        ans = 0L;
        while(ap < sumASize && bp >= 0) 
        {
            int aTmp = ((Integer)sumA.get(ap)).intValue();
            int bTmp = ((Integer)sumB.get(bp)).intValue();
            int aCnt = 0;
            int bCnt = 0;
            if(aTmp + bTmp == T)
            {
                while(ap < sumASize && ((Integer)sumA.get(ap)).intValue() == aTmp) 
                {
                    ap++;
                    aCnt++;
                }
                while(bp >= 0 && ((Integer)sumB.get(bp)).intValue() == bTmp) 
                {
                    bp--;
                    bCnt++;
                }
                ans += (long)aCnt * (long)bCnt;
            } else
            if(aTmp + bTmp > T)
                bp--;
            else
                ap++;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    static int T;
    static int N;
    static int M;
    static int A[];
    static int B[];
    static int ap;
    static int bp;
    static long ans;
    static ArrayList sumA;
    static ArrayList sumB;
}
