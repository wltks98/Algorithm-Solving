
# n=3
# arr=[[1, 3, 1],
# [2, 1, 2],
# [3, 3, 3]]

n=3
arr=[[0, 2, 1],
[1, 1, 1],
[2, 0, 0]]

count=[]

num=[0]*n

for i in range(3):
    count.append(sum(arr[i]))
    for j in range(n):
        num[j]+=arr[i][j]

if(sorted(count)==sorted(num)):
    print("Possible")
else:
    print("Impossible")



