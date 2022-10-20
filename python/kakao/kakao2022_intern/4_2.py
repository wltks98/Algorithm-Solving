import math
import sys
sys.setrecursionlimit(10**6)

ans=math.inf
answer=[ans,ans]


def dfs(start,visit,summit,maxn,graph,summits,gates):
    
    global ans,answer


    if start in summits:
        summit=start
        visit=0       

    for node,w in graph[start]:
        #print('node',node)
        if node in summits:
            if summit !=0: #이미 정상을 방문했으면 다음이 정상이여도 안감
                continue

        if node in gates: 
            if summit !=0: #다음게 게이트인데 가는 상황은 이미 정상을 갔다 왔을떼
                if ans>=max(maxn,w):
                    ans=max(maxn,w)
                    if summit<answer[0]:
                        answer=[summit,ans]
                    else:
                        answer[1]=ans
                    print(answer)
            continue
                

        if not (visit&(1<<node)): #게이트가 아니고 방문하지 않았으면
            #print(node)
            dfs(node,visit|(1<<node),summit,max(maxn,w),graph,summits,gates)

def solution(n, paths, gates, summits):
    graph=[[]for _ in range(n+1)]


    for path in paths:
        a,b,w=path
        graph[a].append((b,w))
        graph[b].append((a,w))

    
    for i in gates:
        dfs(i,0,0,0,graph,summits,gates)
    
    return answer


n=7
paths=[[1, 4, 4], [1, 6, 1], [1, 7, 3], [2, 5, 2], [3, 7, 4], [5, 6, 6]]
gates=[1]
summits=[2,3,4]
print(solution(n, paths, gates, summits))