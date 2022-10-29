import heapq

n=int(input())
arr=[]
for i in range(n):
    arr.append(int(input()))

heapq.heapify(arr)

if len(arr)==1:
    print(0)
else:
    sum=0
    for i in range(n-1):
        
        tmp=heapq.heappop(arr)+heapq.heappop(arr)
        
        sum+=tmp
        heapq.heappush(arr,tmp)
    
    print(sum)