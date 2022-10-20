arr=[1,5,5,1]
threshold=2

n=len(arr)

dp=[0]*n

min=int(1e9)

for j in range(1,threshold+1):
    dp[0][j]=sum(arr[:j])

for i in range(n):
    for j in range(1,threshold+1):
        dp[i][j]=dp[i-1][j]+arr[i]

print(min)