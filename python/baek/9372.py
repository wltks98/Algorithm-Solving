t=int(input())
for _ in range(t):
    n,m=map(int,input().split())
    tree=[[] for _ in range(n+1)]
    visited=[False]*(n+1)
    cnt=-1

    for i in range(m):
        a,b=map(int,input().split())

        tree[a].append(b)
        tree[b].append(a)



    def prim(start):
        global cnt
        if(visited[start]==False):
            visited[start]=True
            cnt+=1
        else:
            return
        
        for node in tree[start]:
            prim(node)

    prim(1)

    print(cnt)