n=int(input())

tree=[[] for _ in range(n+1)]

cost=[0]

for i in range(1,n+1):
    arr=list(map(int, input().split()))
    cost.append(arr[0])
    for j in range(1,len(arr)-1):
        tree[arr[j]].append(i)

print(tree)