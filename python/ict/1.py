px=[2, 3, 8, 1, 2, 4,2, 10, 1]

# px=[]

# for i in range(101):
#     px.append(int(input()))



n=len(px)

dp=[0]*n


minn=px[0]
maxn=px[0]

for i in range(1,n):

    if(minn<=px[i]):
        if(px[i]>maxn):
            dp[i]=dp[i-1]+px[i]-maxn
            maxn=px[i]
        else:
            dp[i]=dp[i-1]
    else:
        minn=px[i]
        maxn=px[i]
        dp[i]=0

answer=max(dp)

if(answer==0):
    answer=-1

print(dp)
# print(minn)

