numInvest, numCompany = list(map(int, input().split()))

listTable = [[0 for _ in range(numCompany + 1)]]

dp = [[0] * (numCompany+1) for _ in range(numInvest+1)]
dpPos = [[[0 for _ in range(numCompany+1)] for _ in range(numCompany+1)] for _ in range(numInvest+1)]

for i in range(1, numInvest+1):
    listTable.append(list(map(int, input().split())))

for i in range(1, numInvest+1):
    for j in range(1,numCompany+1):
        maxValue = 0
        for k in range(i):
            if dp[k][j-1]+listTable[i-k][j] > maxValue:
                maxValue = dp[k][j-1]+listTable[i-k][j]
                maxPos = dpPos[k][j-1][:]
                maxPos[j] = i-k
        if maxValue > dp[i][j-1] :
            dp[i][j] = maxValue
            dpPos[i][j] = maxPos[:]
        else:
            dp[i][j] = dp[i][j-1]
            dpPos[i][j] = dpPos[i][j-1][:]
            
print(dp[numInvest][numCompany])
print(*dpPos[numInvest][numCompany][1:])