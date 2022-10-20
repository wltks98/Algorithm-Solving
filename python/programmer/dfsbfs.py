n=3
computers=[[1, 1, 0], [1, 1, 0], [0, 0, 1]]

def dfs(start, visit,n,computers):

    for j in range(1,n):
        if not visit[j] and computers[start][j]==1:
            visit[j]=True
            dfs(j, visit,n,computers)



for i in range(n):
    computers[i][i]=0


visit=[False]*n




count=0
for i in range(n):
    if not visit[i]:
        count+=1
        visit[i]=True
        dfs(i, visit,n,computers)

print(count)


