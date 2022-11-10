from collections import defaultdict
import heapq


n = int(input())
m = int(input())

graph=defaultdict(list)

for i in range(m):
    a,b,c=map(int,input().split())
    graph[a].append((c,b))

start,target = map(int,input().split())

INF=int(1e9)

distance=[INF]*(n+1)
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        dist, node = heapq.heappop(q)

        if distance[node] < dist:
            continue

        for g in graph[node]:
            c,next=g
            cost=dist+c
            if cost < distance[next]:
                distance[next]=cost
                heapq.heappush(q,(cost,next))
    


dijkstra(start)
print(distance[target])