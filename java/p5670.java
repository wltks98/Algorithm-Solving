// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p5670.java

import java.io.*;
import java.util.HashMap;

public class p5670
{
    /* member class not found */
    class Trie {}

    static class TrieNode
    {

        HashMap childNodes;
        boolean last;

        TrieNode()
        {
            childNodes = new HashMap();
        }
    }


    public p5670()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(String input = ""; (input = br.readLine()) != null;)
        {
            int n = Integer.parseInt(input);
            Trie trie = new Trie();
            String words[] = new String[n];
            double answer = 0.0D;
            for(int i = 0; i < n; i++)
            {
                words[i] = br.readLine();
                trie.insert(words[i]);
            }

            for(int i = 0; i < n; i++)
                answer += trie.countCheck(words[i]);

            System.out.println(String.format("%.2f", new Object[] {
                Double.valueOf(answer / (double)n)
            }));
        }

    }
}
