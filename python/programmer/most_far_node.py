from collections import deque


n=6
vertex=[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]

graph=[[] for _ in range(n+1)]

for v in vertex:
    a,b=v
    graph[a].append(b)
    graph[b].append(a)

distance=[0 for _ in range(n+1)]

visited=[False for _ in range(n+1)]

q=deque()
q.append([1,0])

visited[1]=True
while q:
    node,dis=q.popleft()
    
    print(node,dis)

    for next in graph[node]:
        if not visited[next]:
            visited[next]=True
            q.append([next,dis+1])
            distance[next]=dis+1

print(distance.count(max(distance)))
# print([i for i, ele in enumerate(distance) if ele == max(distance)])

