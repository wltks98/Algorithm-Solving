import math
import sys
sys.setrecursionlimit(10**6)

n=7
paths=[[1, 2, 5], [1, 4, 1], [2, 3, 1], [2, 6, 7], [4, 5, 1], [5, 6, 1], [6, 7, 1]]
gates=[3,7]
summits=[1,5]

graph=[[]for _ in range(n+1)]

for path in paths:
    a,b,w=path
    graph[a].append((b,w))
    graph[b].append((a,w))

ans=math.inf
answer=[ans,ans]

def dfs(start,visit,summit,maxn):
    
    global ans,answer



    if start in summits:
        summit=start
        visit=0       

    for node,w in graph[start]:
        if node in summits:
            if summit !=0: #이미 정상을 방문했으면 다음이 정상이여도 안감
                continue

        if node in gates: 
            if summit !=0: #다음게 게이트인데 가는 상황은 이미 정상을 갔다 왔을떼
                print('도착',node,maxn,w)
                if ans>=max(maxn,w):
                    ans=max(maxn,w)
                    if summit<answer[0]:
                        answer=[summit,ans]
                    else:
                        answer[1]=ans
                    print(answer)
            continue
                

        if not (visit&(1<<node)): #게이트가 아니고 방문하지 않았으면
            print('go',start,'->',node)
            dfs(node,visit|(1<<node),summit,max(maxn,w))


for i in gates:
    print('start',i)
    dfs(i,0,0,0)

print(answer)
print(graph)