queue1=[2, 4, 5, 1, 8]
queue2=[0, 2, 8, 1, 5, 4]

sum1=sum(queue1)
sum2=sum(queue2)
summmm=sum1+sum2
answer=0

check=queue1.copy()
while sum1 != sum2:
    if summmm%2==1:
        answer=-1
        break
    #print(sum1,sum2)

    if sum1>sum2:
        dif=sum1-sum2
        

        temp_sum=queue1[0]
        index=0

        for i in range(1,len(queue1)):
            if temp_sum>=dif//2:
                break
            temp_sum+=queue1[i]
            index=i
        

        # queue2.extend(queue1[:index+1])
        # del queue1[:index+1]
        for i in range(index+1):
            queue2.append(queue1.pop(0))
            answer+=1
        

    
    else:
        dif=sum2-sum1

        temp_sum=queue2[0]
        index=0

        for i in range(1,len(queue2)):
            if temp_sum>=dif//2:
                break
            temp_sum+=queue2[i]
            index=i
        
        
        
        # queue1.extend(queue2[:index+1])
        # del queue2[:index+1]
        for i in range(index+1):
            queue1.append(queue2.pop(0))
            answer+=1

    if queue1==check:
        answer=-1
        break

    if not (queue1 and queue2):
        answer=-1
        break
    
    #print(queue1,queue2)

    sum1=sum(queue1)
    sum2=sum(queue2)


print(answer)
