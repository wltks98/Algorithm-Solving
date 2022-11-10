import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N, M = map(int, input().split())
sand = [[0 for _ in range(M)] for _ in range(N)]
for i in range(N):
    info = list(map(int, input().split()))
    for j in range(M):
        sand[i][j] = info[j]
        
visit = [[0 for _ in range(M)] for _ in range(N)]
upd = [[0 for _ in range(M)] for _ in range(N)]
dx = (1, -1, 0, 0)
dy = (0, 0, 1, -1)

def DFS(cur, prev):
    cy, cx = cur
    for k in range(4):
        ny, nx = cy + dy[k], cx + dx[k]
        if ny < 0 or nx < 0 or ny >= N or nx >= M:
            continue
        if visit[ny][nx] or not sand[ny][nx]:
            continue
        visit[ny][nx] = 1
        DFS([ny, nx], cur)

t = 0
while 1:
    island = 0
    for i in range(N):
        for j in range(M):
            if visit[i][j] or not sand[i][j]:
                continue
            visit[i][j] = 1
            island += 1
            DFS([i, j], [i, j])
    
    if island > 1:
        print(t)
        exit(0)

    if island == 0:
        print(-1)
        exit(0)
  
    for i in range(N):
        for j in range(M):
            for k in range(4):
                ni, nj = i + dy[k], j + dx[k]
                if ni < 0 or nj < 0 or ni >= N or nj >= M: continue
                if not sand[ni][nj]:
                    upd[i][j] = 1
                    
    for i in range(N):
        for j in range(M):
            if upd[i][j]:
                sand[i][j] = 0
    
    for i in range(N):
        for j in range(M):
            upd[i][j] = visit[i][j] = 0
    t += 1