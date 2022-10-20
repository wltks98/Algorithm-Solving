# 특정 원소가 속한 집합을 찾기
def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


n = int(input())
parent = [0] * (n + 1) 


for i in range(1, n + 1):
    parent[i] = i



for i in range(n):
    a, b = map(int, input().split())

    if find(parent, a) == find(parent, b):
        print(a,b)

    else:
        union(parent, a, b)

