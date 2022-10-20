#25번 케이스는 틀림

board=[[0, 0, 0, 0, 0, 0, 0, 0], [1, 0, 1, 1, 1, 1, 1, 0], [1, 0, 0, 1, 0, 0, 0, 0], [1, 1, 0, 0, 0, 1, 1, 1], [1, 1, 1, 1, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1, 1, 0], [1, 1, 1, 1, 1, 1, 1, 0], [1, 1, 1, 1, 1, 1, 1, 0]]

n = len(board)
queue = [(0,0,-1,0)] 
distance = [[0 for _ in range(n)] for _ in range(n)]

answer = int(1e9)

dx = [1, -1, 0, 0] 
dy = [0, 0, -1, 1]

while queue:
    y, x, d, c = queue.pop(0)
    if (x,y) == (n-1, n-1):
        if(answer>c):
            answer = c

    
    for i in range(4):    

        nx = x + dx[i]
        ny = y + dy[i]


        if ny <= -1 or ny >= n or nx <= -1 or nx >= n:
            continue
        
        if board[ny][nx]:
            continue

        cost = c + (100 if d == i or d == -1 else 600)
        if distance[ny][nx] != 0 and distance[ny][nx] < cost:
            continue
            
        queue.append((ny, nx, i, cost))
        distance[ny][nx] = cost

print(answer)