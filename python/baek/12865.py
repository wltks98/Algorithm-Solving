n,k = list(map(int,input().split()))
dp=[[0]*(k+1) for _ in range(n+1)]

arr=[]

for i in range(n):
    arr.apend(list(map(int,input().split())))

for i in range(1,n+1):
    w,v=arr[i-1]
    for j in range(1,k+1):
        dp[i][j]=max(dp[i-1][j],dp[i-1][j-w]+v)

print(dp[i][j])