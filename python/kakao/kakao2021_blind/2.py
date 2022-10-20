import itertools
from unittest import result

orders=["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
course=[2,3,4]

answer=[]

s=set(list("".join(orders)))

for a in course:
    arr=list(itertools.combinations(s,a))
    
    for res in arr:
        str="".join(res)
        count=0
        for ord in orders:
            if(str in ord):
                count+=1
            if(count==2):
                answer.append(str)
                break

print(answer)