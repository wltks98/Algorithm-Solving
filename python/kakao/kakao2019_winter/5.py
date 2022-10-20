import math


stones=[2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
k=3

n=len(stones)

left=1
right=max(stones)

def check(num):
    count=0

    for stone in stones:
        if stone<=num:
            count+=1
            if count==k:
                return False
        else:
            count=0

    return True

while left<=right:
    mid=(left+right)//2

    if check(mid):
        answer=mid+1
        left=mid+1
    else:
        right=mid-1


print(answer)
    
