#왠지 모르게 안됨

import collections

places=[["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
 ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], 
["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], 
["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], 
["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]

answer=[1]*5

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(5):
    arr=places[i]
    people=[]
        
    for j in range(5):
        for k in range(5):
            if(arr[j][k]=='P'):
                people.append([j,k])

    for k in range(len(people)):
        q=collections.deque()
        q.append(people[k])
        distance=[[0]*5 for _ in range(5)]
        visited=[[False]*5 for _ in range(5)]

        while(q and answer[i]==1):
            x,y=q.pop()
            visited[x][y]=True

            for j in range(4):
                nx=x+dx[j]
                ny=y+dy[j]

                if(visited[nx][ny]):
                    continue

                if(nx<0 or nx>=5 or ny<0 or ny>=5):
                    continue

                if(arr[nx][ny]=='X'):
                    continue

                
                people.append([nx,ny])
                distance[nx][ny]=distance[x][y]+1
                if(arr[nx][ny]=='P' and distance[nx][ny]<=2):
                    answer[i]=0
                    break

print(answer)

