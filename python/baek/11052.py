n=int(input())
arr=[0]+list(map(int,input().split()))

dp=[[0]*(n+1) for _ in range(n+1)]



for i in range(1,n+1):
    for j in range(1,n+1):
        if(j>=i):
            dp[i][j]=max(dp[i-1][j],dp[i][j-i]+arr[i])
        else:
            dp[i][j]=dp[i-1][j]

print(dp[n][n])

#최적의 코드
# N = int(input())
# p = [0] + list(map(int,input().split()))
# dp = [0 for _ in range(N+1)]


# for i in range(1,N+1):
#     for k in range(1,i+1):
#         dp[i] = max(dp[i], dp[i-k] + p[k])
# print(dp[i])