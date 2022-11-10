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
		
		if arr[nx][ny]>0:
			arr[nx][ny]+=1
			if arr[nx][ny]==3:
				arr[nx][ny]=-1
			continue
			
		if not visited[nx][ny] and arr[nx][ny]==0:
			visited[nx][ny]=True
			dfs(nx,ny)
	return

def check():
    for i in range(n):
        for j in range(m):
            if arr[i][j] !=0:
                return False
    return True
    


time=0



while True:
    if check():
        print(time)
        exit(0)


    visited[0][0]=True
    dfs(0,0)
    
    
    for i in range(n):
        for j in range(m):
            if arr[i][j]==-1:
                arr[i][j]=0
            if arr[i][j]>0:
                arr[i][j]=1	
            visited[i][j]=False

    

    time+=1

			

			
			
			


