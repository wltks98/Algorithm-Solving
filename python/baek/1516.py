n=int(input())

tree=[[] for _ in range(n+1)]

cost=[0]
dp=[0 for _ in range(n+1)]

for i in range(1,n+1):
    arr=list(map(int, input().split()))
    cost.append(arr[0])

    for j in range(1,len(arr)-1):
        tree[i].append(arr[j])

def dfs(i):
    if dp[i]:
        return dp[i]

    if len(tree[i])==0:
        return cost[i]

    m=0
    for node in tree[i]:
        if not dp[node]:
            m=max(m,dfs(node))
    return m+cost[i]


for i in range(1,n+1):
    if len(tree[i])==0:
        if not dp[i]:
            dp[i]=cost[i]
    else:
        if not dp[i]:
            m=0
            for node in tree[i]:
                m=max(m,dfs(node))
            dp[i]=m+cost[i]

print(dp[1:])