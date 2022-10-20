sticker=[14, 6, 5, 11, 3, 9, 2, 10]

n=len(sticker)

dp1=[0 for _ in range(n)]
dp2=[0 for _ in range(n)]

dp1[0]=sticker[0]
dp1[1]=sticker[0]


dp2[1]=sticker[1]



if(n==1):
    answer=sticker[0]

if(n==2):
    answer=max(sticker)

for i in range(2,n-1):
    dp1[i]=max(dp1[i-1],dp1[i-2]+sticker[i])
    dp2[i]=max(dp2[i-1],dp2[i-2]+sticker[i])

dp2[n-1]=max(dp2[n-2],dp2[n-3]+sticker[n-1])

answer=max(max(dp1),max(dp2))

