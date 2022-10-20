from collections import deque
import sys

input = sys.stdin.readline
dx = [-1, 0, 0, 1]
dy = [0, -1, 1, 0]

def bfs(x, y, weight, time, eat):
    q, can_eat = deque(), []
    q.append([x, y])
    c = [[-1]*n for _ in range(n)]  #칸마다 시간을 저장하기 위한 배열
    c[x][y] = time
    while q:
        qlen = len(q)
        while qlen:
            x, y = q.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < n and 0 <= ny < n:
                    if c[nx][ny] == -1: #한번도 안갔는가
                        if a[nx][ny] == 0 or a[nx][ny] == weight:
                            c[nx][ny] = c[x][y] + 1
                            q.append([nx, ny])
                        elif 0 < a[nx][ny] < weight:
                            can_eat.append([nx, ny])
            qlen -= 1

        if can_eat:
            nx, ny = min(can_eat)
            eat += 1
            if eat == weight:
                eat = 0
                weight += 1
            a[nx][ny] = 0   #먹은 물고기는 0으로
            return nx, ny, weight, c[x][y] + 1, eat

    print(time) #큐가 비면 시스템 종료
    sys.exit()

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    for j in range(n):
        if a[i][j] == 9:
            x, y = i, j
            a[i][j] = 0

weight, time, eat = 2, 0, 0
while True:
    x, y, weight, time, eat = bfs(x, y, weight, time, eat) #한 번 먹을때마다 bfs다시 실행