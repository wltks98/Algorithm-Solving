# queue1=[4,2,2,4]
# queue2=[1,1,1,1]

queue1=[1, 1, 1, 1, 1, 1, 1, 1, 1, 10]
queue2=[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

sum1=sum(queue1)
sum2=sum(queue2)

target=(sum1+sum2)//2


l=0
r=len(queue1)-1


queue1.extend(queue2)
n=len(queue1)

summ=sum1
count=0



while l<r and r<n-1:
    if(summ==target):
        break

    if(summ<target):
        r+=1
        summ+=queue1[r]
    else:
        summ-=queue1[l]
        l+=1
        
    count+=1

print(count)


