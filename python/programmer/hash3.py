from ast import operator
from numpy import sort


geners=['A', 'A', 'B']
plays=[600, 500, 300]

index=[i for i in range(len(plays))]

dic={}
count={}
answer=[]

for a,b,i in zip(geners,plays,index):
    if a in dic:
        dic[a]+=b
        count[a].append([b,i])
    else:
        dic[a]=b
        count[a]=[[b,i]]


dic=sorted(dic.items(), key=lambda x: -x[1])

for d,z in dic:
    arr=sorted(count[d],key=lambda x: (-x[0], x[1]))
    print(arr)
    c=0
    for i,j in arr:
        answer.append(j)
        c+=1
        if(c==2):
            break


print(answer)


