n,k=map(int,input().split())
arr=[[0]*1001 for _ in range(1001)]
answer=0
for i in range(n):
    x1,y1,x2,y2=map(int,input().split())
    arr[x1][y1]+=1
    arr[x1][y2]-=1
    arr[x2][y1]-=1
    arr[x2][y2]+=1


for i in range(len(arr) - 1):
    for j in range(len(arr[0]) - 1):
        arr[i][j + 1] += arr[i][j]

# 열 기준 누적합
for j in range(len(arr[0]) - 1):
    for i in range(len(arr) - 1):
        arr[i + 1][j] += arr[i][j]

# 기존 배열과 합함
for i in range(1001):
    for j in range(1001):
        if arr[i][j] >= k: answer += 1
print(answer)