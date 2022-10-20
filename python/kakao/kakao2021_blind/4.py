import math
import sys
sys.setrecursionlimit(10**6)

sales=[14, 17, 15, 18, 19, 14, 13, 16, 28, 17]
links=[[10, 8], [1, 9], [9, 7], [5, 4], [1, 5], [5, 10], [10, 6], [1, 3], [10, 2]]

dp=[[0,0] for _ in range(300001)]
child=[[] for _ in range(300001)]

def dfs(sales, node):
    dp[node][0]=0
    dp[node][1]=sales[node-1]

    if not child[node]:
        return 
    
    cost=math.inf
    for ch in child[node]:
        dfs(sales,ch)
        if dp[ch][0] < dp[ch][1]:
            dp[node][0]+=dp[ch][0]
            dp[node][1]+=dp[ch][0]
            cost=min(cost,dp[ch][1]-dp[ch][0])
        else:
            dp[node][0]+=dp[ch][1]
            dp[node][1]+=dp[ch][1]
            cost=0
    dp[node][0]+=cost



def solution(sales, links):
    for link in links:
        x,y=link
        child[x].append(y)
    dfs(sales,1)
    return min(dp[1][0],dp[1][1])



print(solution(sales,links))




