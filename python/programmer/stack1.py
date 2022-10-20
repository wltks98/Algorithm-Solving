import math


progress=[93, 30, 55]
speeds=[1, 30, 5]

arr=[]
stack=[]
answer=[]

for p,s in zip(progress,speeds):

    num=math.ceil((100-p)/s)

    arr.append(num)

count=0
for i in range(len(arr)):
    if stack:
        if(arr[i]<=stack[-1]):
            count+=1
        else:
            answer.append(count)
            count=1
            stack.append(arr[i])

        
    else:
        stack.append(arr[i])
        count+=1

answer.append(count)

print(answer)