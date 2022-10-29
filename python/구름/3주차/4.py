import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)
from collections import defaultdict

n = int(input())
graph = defaultdict(list)
for i in range(n):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False for _ in range(n+1)]

circle = list()
last = -1

def FindCycle(u, tar):
    global last
    if visited[u] == 1:
        last = u
        if u not in circle:
            circle.append(u)
        return
    visited[u] = 1
    for i in graph[u]:
        if i == tar:
            continue
        FindCycle(i, u)

        if last == -2:
            return
        if last == u:
            last = -2
            return

        if last >= 0:
            if u not in circle:
                circle.append(u)
            return

FindCycle(1, last)
circle.sort()
print(len(circle))
print(*circle)