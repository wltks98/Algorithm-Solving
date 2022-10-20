import heapq

works=[4, 3, 3]
n=4




works=[-w for w in works]


heapq.heapify(works)


for i in range(n):
    num=heapq.heappop(works)
    num+=1
    heapq.heappush(works,num)

ansewr=sum([w**2 for w in works])