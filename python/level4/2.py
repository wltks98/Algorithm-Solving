from collections import deque


land=[[1, 4, 8, 10], [5, 5, 5, 5], [10, 10, 10, 10], [10, 10, 10, 20]]
height=3

dx=[1,-1,0,0]
dy=[0,0,1,-1]


n=len(land)

color=0

visited=[[False]*n for _ in range(n)]

boundary=[[]*(n*n)]


q=deque()

q.append(((0,0),color))

while q:
    index,c=q.popleft()
    x,y=index

    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]

        if nx<0 or nx>=n or ny<0 or ny>=n:
            continue

        if visited[nx][ny]:
            continue

        if abs(land[nx][ny]-land[x][y])>=height:
            boundary[color].append([[x,y],[nx,ny]])
            continue

        visited[nx][ny]=True
        q.append(((nx,ny),color))



