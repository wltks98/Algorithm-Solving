import math


N=16
stations=[9]
W=2

arr=[]
arr.append(stations[0]-W-1)

answer=0

for i in range(1,len(stations)):
    arr.append(stations[i]-2*W-stations[i-1]-1)

if N-stations[-1]<=W:
    arr.append(0)
else:
    arr.append(N-stations[-1]-W)

wide=2*W+1

for a in arr:
    answer+=math.ceil(a/wide)

print(arr)
print(answer)
