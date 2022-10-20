import sys
INF = float('inf')
n = int(sys.stdin.readline()) 
d = [] 
for _ in range(n): 
    d.append(list(map(int, sys.stdin.readline().split()))) 

dp = [[-1] * (1 << n) for _ in range(20)] #dp[i][j]는 i번째 사람 순서에서 j방문상태(방문은 몇번째 일들이 할당됬나를 의미) 일때 남은 비용 

def dfs(x, visited): 
    if visited == (1 << n) - 1: #모두 방문한 상태면 0
        return 0 
    if dp[x][visited] != -1: #계산한 적이 있으면 return
        return dp[x][visited] 
    
    dp[x][visited] = INF 
    
    for i in range(n): 

        if visited & (1 << i): #i는 첫번째 일이 할당 됬는지 인데 즉 현재 i가 할당된 상태이면 continue
            continue 

        dp[x][visited] = min(dp[x][visited], dfs(x + 1, visited | (1 << i)) + d[x][i]) 

    return dp[x][visited] 
        
print(dfs(0, 0))

# import sys
# input = sys.stdin.readline
# N = int(input())
# cost = [[*map(int, input().split())] for _ in range(N)]
# dp=[10**6]*(1<<N)
# dp[0]=0

# for i in range(1<<N):
#     k = 0
#     for j in range(N):
#         if i & (1<<j):
#             k+=1
#     for j in range(N):
#         if i & (1 << j) == 0 and dp[i|(1<<j)] > dp[i]+cost[k][j]:
#             dp[i|(1<<j)] = dp[i] + cost[k][j]

# print(dp[-1])

