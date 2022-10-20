stones=[2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
k=3

left=1
right=max(stones)
answer=0
while left<=right:
    mid=(left+right)//2

    count=0

    for stone in stones:
        if stone<=mid:
            count+=1
        else:
            count=0
        if count>=k:
            break
    
    if count < k:
        left= mid+1
    else:
        right=mid-1
        answer=mid

print(answer)