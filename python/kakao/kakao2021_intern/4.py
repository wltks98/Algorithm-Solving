import math
from heapq import heappop,heappush

n=4
start=1
end=4
roads=[[1, 2, 1], [3, 2, 1], [2, 4, 1]]
traps=[2,3]

inf=math.inf

graph=[[inf for _ in range(n+1)] for _ in range(n+1)]

for i in range(1,n+1):
	graph[i][i]=0

for data in roads:
	u,v,w=data
	if w<graph[u][v]:
		graph[u][v]=w

def di():
	q=[]
	visited=[[False for _ in range(len(traps))]for _ in range (n+1)]
	heappush(q,(0,start,0))

	while q:
		w,u,state=heappop(q)

		if u==end:
			return w
		
		if visited[u][state]:
			continue
		visited[u][state]=True

		currTrapped = False
		trapped={}

		for i in range(len(traps)):
			bit=1<<i
			if state & bit:
				if traps[i]==u:
					state &= ~bit
				else:
					trapped[traps[i]]=True
			else:
				if traps[i]==u:
					state |=bit
					trapped[traps[i]]=True
					currTrapped=True
		
		for v in range(1,n+1):
			if v ==u:
				continue
			nextTrapped = True if v in trapped else False
			if currTrapped==nextTrapped:
				if graph[u][v] != inf:
					heappush(q,(w+graph[u][v],v,state))
			else:
				if graph[v][u] != inf:
					heappush(q,(w+graph[v][u],v,state))
	return inf

		
