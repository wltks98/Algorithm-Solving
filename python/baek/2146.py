from collections import deque

n,m=map(int,input().split())

arr=[]


for i in range(n):
	arr.append(list(map(int,input().split())))

visited=[[False]*m for _ in range(n)]
	
dx=[1,-1,0,0]
dy=[0,0,1,-1]

q=deque()

for i in range(n):
    for j in range(m):
        for k in range(4):
            nx=i+dx[k]
            ny=i+dy[k]
            if nx<0 or ny<0 or nx>=n or ny>=m:
                continue
            
            if arr[nx][ny]==1:
                q.append([0, nx,ny])

visited=[[False]*m for _ in range(n)]

while q:
    a,x,y=q.popleft()
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]

        if nx<0 or ny<0 or nx>=n or ny>=m:
                continue

        if not visited[nx][ny] and arr[nx][ny]==0:
