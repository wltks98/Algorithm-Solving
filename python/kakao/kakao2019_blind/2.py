from collections import Counter

N=5
stages=[2, 1, 2, 6, 2, 4, 3, 3]

dic={}
answer=[]

total=len(stages)

a=Counter(stages)


for i in range(1,N+1):
    if total>0:
        dic[i]=a[i]/total
    else:
        dic[i]=0
    total-=a[i]

answer=sorted(dic,key=lambda x:dic[x], reverse=True)

print(answer)