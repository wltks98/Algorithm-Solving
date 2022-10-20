// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p5639.java

import java.io.*;

public class p5639
{
    static class Node
    {

        void insert(int n)
        {
            if(n < num)
            {
                if(left == null)
                    left = new Node(n);
                else
                    left.insert(n);
            } else
            if(right == null)
                right = new Node(n);
            else
                right.insert(n);
        }

        int num;
        Node left;
        Node right;

        Node(int num)
        {
            this.num = num;
        }

        Node(int num, Node left, Node right)
        {
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }


    public p5639()
    {
    }

    public static void main(String args[])
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        do
        {
            String input = br.readLine();
            if(input != null && !input.equals(""))
            {
                root.insert(Integer.parseInt(input));
            } else
            {
                postOrder(root);
                return;
            }
        } while(true);
    }

    static void postOrder(Node node)
    {
        if(node == null)
        {
            return;
        } else
        {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.num);
            return;
        }
    }
}
