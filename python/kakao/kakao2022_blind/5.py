import sys
sys.setrecursionlimit=10**9

info=[0,1,0,1,1,0,1,0,0,1,0]
edges=[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]

n=len(info)
tree=[[] for _ in range(n)]

maxi=0

def dfs(start,sheep,wolf,visit,visit2):

    global maxi

    if (visit | 1<<start) !=visit: #처음 방문해서 동물을 데려간다는 뜻
        visit=visit | 1<<start
        visit2=0

        if info[start]==0:
            sheep+=1
        else:
            wolf+=1
    
        if sheep>wolf:
            if maxi<sheep:
                maxi=sheep
        else:
            sheep=0
            return

        if visit==1<<n:
            return
    

    visit2=visit2 | 1<<start

    for node in tree[start]:
        if (visit2 | 1<<node) !=visit2: #갈수있으면
            dfs(node,sheep,wolf,visit, visit2)


for edge in edges:
    a,b=edge
    tree[a].append(b)
    tree[b].append(a)

dfs(0,0,0,0,0)

print(maxi)