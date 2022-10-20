import sys
sys.setrecursionlimit(10**9)

n=9
path=[[0,1],[0,3],[0,7],[8,1],[3,6],[1,2],[4,7],[7,5]]
order=[[4,1],[8,7],[6,5]]


tree=[[] for _ in range(n)]

parent=[[]for _ in range(n)]
visited=[False for _ in range(n)]
possible=[False for _ in range(n)]

for p in path:
    tree[p[0]].append(p[1])
    tree[p[1]].append(p[0])

for o in order:
    parent[o[1]].append(o[0])


def find_parent(p):
    for node in tree[p]:
        if(visited[node]==False):
            parent[node].append(p)
            visited[node]=True

visited[0]=True
for i in range(n):
    find_parent(i)


possible[0]=True

def check(node,first):

    for p in parent[node]:
        if(p==first):
            return False
        if(possible[p]==False):
            if(check(p,first)==False):
                return False
    
    return True

print(parent)

for i in range(n):
    if(check(i,i)):
        possible[i]=True
        parent[i]=[]


print(possible)