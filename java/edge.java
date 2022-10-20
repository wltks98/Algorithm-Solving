// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   p17472.java


class edge
    implements Comparable
{

    public edge(int s, int e, int v)
    {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    public int compareTo(edge arg0)
    {
        return arg0.v < v ? 1 : -1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((edge)obj);
    }

    int s;
    int e;
    int v;
}
