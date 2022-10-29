from collections import deque
n = int(input())

arr=[[-1 for _ in range(n+2)] for _ in range(n+2)]


for i in range(n):
	arr[i+1]=[-1]+list(map(int,input().split()))+[-1]

	
dx=[1,-1,0,0]
dy=[0,0,1,-1]
q=deque()
for i in range(1,n+1):
	for j in range(1,n+1):
		if arr[i][j]!=0 and arr[i][j]!=-1:
			q.append([i,j])

day=0		
		
while q:
	day+=1
	visited=[]
	l=len(q)
	for j in range(l):
		x,y=q.popleft()
		

		
		for i in range(4):
			nx=x+dx[i]
			ny=y+dy[i]
			
			if (nx,ny) in visited:
				
				continue
			
			if arr[nx][ny]==0:
				
				arr[x][y]-=1
			
			if arr[x][y]==0:
				visited.append((x,y))
				break
		
		if arr[x][y]!=0:
			q.append([x,y])
	

			
			
			
print(day)
			
			
			