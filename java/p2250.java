// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p2250.java

import java.io.PrintStream;
import java.util.*;

public class p2250
{
    static class Node
    {

        int parent;
        int num;
        int left;
        int right;

        Node(int num, int left, int right)
        {
            parent = -1;
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }


    public p2250()
    {
    }

    public static void main(String args[])
    {
        int n = scanner.nextInt();
        levelMin = new int[n + 1];
        levelMax = new int[n + 1];
        int rootIndex = 0;
        for(int i = 0; i <= n; i++)
        {
            tree.add(new Node(i, -1, -1));
            levelMin[i] = n;
            levelMax[i] = 0;
        }

        for(int i = 0; i < n; i++)
        {
            int num = scanner.nextInt();
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            ((Node)tree.get(num)).left = left;
            ((Node)tree.get(num)).right = right;
            if(left != -1)
                ((Node)tree.get(left)).parent = num;
            if(right != -1)
                ((Node)tree.get(right)).parent = num;
        }

        for(int i = 1; i <= n; i++)
        {
            if(((Node)tree.get(i)).parent != -1)
                continue;
            rootIndex = i;
            break;
        }

        inOrder(rootIndex, 1);
        int answerLevel = 1;
        int answerWidth = (levelMax[1] - levelMin[1]) + 1;
        for(int i = 2; i <= maxLevel; i++)
        {
            int width = (levelMax[i] - levelMin[i]) + 1;
            if(answerWidth < width)
            {
                answerLevel = i;
                answerWidth = width;
            }
        }

        System.out.println((new StringBuilder(String.valueOf(answerLevel))).append(" ").append(answerWidth).toString());
    }

    public static void inOrder(int rootIndex, int level)
    {
        Node root = (Node)tree.get(rootIndex);
        if(maxLevel < level)
            maxLevel = level;
        if(root.left != -1)
            inOrder(root.left, level + 1);
        levelMin[level] = Math.min(levelMin[level], point);
        levelMax[level] = point;
        point++;
        if(root.right != -1)
            inOrder(root.right, level + 1);
    }

    static final Scanner scanner;
    static int point = 1;
    static List tree = new ArrayList();
    static int levelMin[];
    static int levelMax[];
    static int maxLevel = 0;

    static 
    {
        scanner = new Scanner(System.in);
    }
}
