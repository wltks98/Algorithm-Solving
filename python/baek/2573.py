import sys
sys.setrecursionlimit(10000)

n,m=map(int,input().split())

arr=[]


for i in range(n):
	arr.append(list(map(int,input().split())))

visited=[[False]*m for _ in range(n)]
	
dx=[1,-1,0,0]
dy=[0,0,1,-1]


def dfs(x,y):

	for i in range(4):
		nx=x+dx[i]
		ny=y+dy[i]
		if nx<0 or ny<0 or nx>=n or ny>=m:
			continue
		
		if arr[nx][ny]==0:
			arr[x][y]-=1
			if arr[x][y]<=0:
				arr[x][y]=-1

			continue
			
		if not visited[nx][ny] and arr[nx][ny]>0:
			visited[nx][ny]=True
			dfs(nx,ny)
	return

year=0	
while True:

	count=0
	for i in range(n):
		for j in range(m):
			if arr[i][j] and not visited[i][j]:
				visited[i][j]=True
				dfs(i,j)
				count+=1
	
	if count==0:
		print(0)
		exit(0)

	if count>=2:
		print(year)
		exit(0)
	
	for i in range(n):
		for j in range(m):
			if arr[i][j]==-1:
				arr[i][j]=0	
			visited[i][j]=False


	year+=1

			

			
			
			


