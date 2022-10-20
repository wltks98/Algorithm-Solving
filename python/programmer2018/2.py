import dis
import heapq
import sys
sys.setrecursionlimit(10**6)

N=5
road=[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]
K=3

def di(start,distance):

    q=[]
    heapq.heappush(q,[0,start])
    distance[start]=0

    while q:
        print(distance)
        dist,next=heapq.heappop(q)
        print(next)
        if(distance[next]<dist):
            continue
        for node in graph[next]:

            cost=dist+node[1]

            if cost<distance[node[0]]:
                distance[node[0]] = cost
                heapq.heappush(q, (cost, node[0]))

INF = int(1e9)
graph=[[]*(N+1) for _ in range(N+1)]
distance=[INF]*(N+1)

for r in road:
    a,b,w=r
    graph[a].append([b,w])
    graph[b].append([a,w])

di(1,distance)

answer=0

for i in range(1,N+1):
    if distance[i]<=K:
        answer+=1

print(graph)
print(answer)
