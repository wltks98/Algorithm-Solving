// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p4803.java

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p4803
{

    public p4803()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = 1;
        do
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n != 0 || m != 0)
            {
                visit = new boolean[n + 1];
                edge_List = new ArrayList[n + 1];
                for(int i = 0; i <= n; i++)
                    edge_List[i] = new ArrayList();

                for(int i = 0; i < m; i++)
                {
                    st = new StringTokenizer(br.readLine());
                    int v1 = Integer.parseInt(st.nextToken());
                    int v2 = Integer.parseInt(st.nextToken());
                    edge_List[v1].add(Integer.valueOf(v2));
                    edge_List[v2].add(Integer.valueOf(v1));
                }

                int count = 0;
                for(int i = 1; i <= n; i++)
                    if(!visit[i] && dfs(i, 0))
                        count++;

                bw.write((new StringBuilder("Case ")).append(testCase++).append(": ").toString());
                if(count <= 1)
                    bw.write(answer[count]);
                else
                    bw.write((new StringBuilder("A forest of ")).append(count).append(" trees.\n").toString());
            } else
            {
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        } while(true);
    }

    public static boolean dfs(int v, int bv)
    {
        visit[v] = true;
        for(int i = 0; i < edge_List[v].size(); i++)
        {
            int nv = ((Integer)edge_List[v].get(i)).intValue();
            if(nv != bv)
            {
                if(visit[nv])
                    return false;
                if(!dfs(nv, v))
                    return false;
            }
        }

        return true;
    }

    static String answer[] = {
        "No trees.\n", "There is one tree.\n"
    };
    static boolean visit[];
    static ArrayList edge_List[];

}
