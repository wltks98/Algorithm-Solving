import heapq


land=[[1, 4, 8, 10], [5, 5, 5, 5], [10, 10, 10, 10], [10, 10, 10, 20]]
height=3

dx=[1,-1,0,0]
dy=[0,0,1,-1]


n=len(land)



visited=[[False]*n for _ in range(n)]


q=[[0,0,0]]
answer=0

while q:
    cost,x,y=heapq.heappop(q)
    print(answer,x,y)

    if visited[x][y]:
        continue

    visited[x][y]=True
    answer+=cost

    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]

        if nx<0 or nx>=n or ny<0 or ny>=n:
            continue

        if visited[nx][ny]:
            continue

        if abs(land[nx][ny]-land[x][y])>height:
            heapq.heappush(q,[abs(land[nx][ny]-land[x][y]),nx,ny])
            continue

        heapq.heappush(q,[0,nx,ny])

    
print(answer)

