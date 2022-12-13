#정답코드

room=[3,1,2,4] 

from collections import defaultdict
import sys
sys.setrecursionlimit(10**6)

def dfs(node,graph,visited):
    next=graph[node][0]
    if not visited[next]:
            visited[next]=True
            dfs(next,graph,visited)
    return

def solution(rooms):
    
    n=len(rooms)
    graph=defaultdict(list)

    for i,room in enumerate(rooms):
        graph[i+1].append(room)

    count=0
    visited=[False]*(n+1)

    for i in range(1,n+1):
        if not visited[i]:
            count+=1
            visited[i]=True
            dfs(i,graph,visited)


    return count-1 if count>1 else 1

print(solution(room))



# q=deque()
    # for a in degree:
    #     if a==0:
    #         q.append(a)

    # count=0
    # while(q):
    #     v=q.popleft()
    #     next=room[v-1]
    #     degree[next]-=1
    #     if degree[next]==0:
    #         q.append(next)