triangle=[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]

h=len(triangle)
w=len(triangle[-1])

dp=[[] for _ in range(h)]

for i,t in enumerate(triangle):
    dp[i]=t


for i in range(1,h):
    for j in range(len(dp[i])):

        if j==0:
            dp[i][j]=dp[i][j]+dp[i-1][j]
        elif j==len(dp[i])-1:
            dp[i][j]=dp[i][j]+dp[i-1][j-1]
        else:
            dp[i][j]=dp[i][j]+max(dp[i-1][j-1],dp[i-1][j])


print(max(dp[-1]))