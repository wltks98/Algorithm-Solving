from collections import defaultdict, deque

n,m,k=list(map(int,input().split()))
graph=defaultdict(list)
for i in range(m):
	a,b=list(map(int,input().split()))
	graph[a].append(b)
	graph[b].append(a)
	
answer="NO"

q=deque([(1,0)])
visited=[False for _ in range (n+1)]
visited[1]=True
while q:
	node,count=q.popleft()
	
	if node==n and count<=k:
		answer="YES"
	
	for next in graph[node]:
		if not visited[next]:
			visited[next]=True
			q.append((next,count+1))

print(answer)
