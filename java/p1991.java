// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p1991.java

import java.io.*;

public class p1991
{
    public static class Node
    {

        char data;
        Node left;
        Node right;

        Node(char data)
        {
            this.data = data;
        }
    }


    public p1991()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n];
        for(int i = 0; i < n; i++)
            tree[i] = new Node((char)(65 + i));

        for(int i = 0; i < n; i++)
        {
            String split[] = br.readLine().split(" ");
            char root = split[0].charAt(0);
            char left = split[1].charAt(0);
            char right = split[2].charAt(0);
            if(left != '.')
                tree[root - 65].left = tree[left - 65];
            if(right != '.')
                tree[root - 65].right = tree[right - 65];
        }

        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        System.out.println(sb);
    }

    public static void preorder(int index)
    {
        sb.append(tree[index].data);
        if(tree[index].left != null)
            preorder(tree[index].left.data - 65);
        if(tree[index].right != null)
            preorder(tree[index].right.data - 65);
    }

    public static void inorder(int index)
    {
        if(tree[index].left != null)
            inorder(tree[index].left.data - 65);
        sb.append(tree[index].data);
        if(tree[index].right != null)
            inorder(tree[index].right.data - 65);
    }

    public static void postorder(int index)
    {
        if(tree[index].left != null)
            postorder(tree[index].left.data - 65);
        if(tree[index].right != null)
            postorder(tree[index].right.data - 65);
        sb.append(tree[index].data);
    }

    static Node tree[];
    static StringBuilder sb = new StringBuilder();

}
