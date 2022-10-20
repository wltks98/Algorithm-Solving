import math

queue1=[4,2,2,4]
queue2=[1,1,1,1]

sum1=sum(queue1)
sum2=sum(queue2)

target=(sum1+sum2)//2


l1=0
r1=len(queue1)-1


queue1.extend(queue2)
n=len(queue1)

start=0
end=0

answer=math.inf

summ=0



for start in range(n):

    while summ < target and end<n:
        summ+=queue1[end]
        end+=1
    if summ==target:
        cost=abs(start-l1)+abs(end-1-r1)
        if cost<answer:
            answer=cost
    summ-=queue1[start]

if answer==math.inf:
    answer=-1

if (sum1+sum2)%2==1:
    answer=-1
print(answer)