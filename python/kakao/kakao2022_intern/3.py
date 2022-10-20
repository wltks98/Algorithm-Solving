import math


a=0
b=0
problems=[[0,0,2,1,2],[4,5,3,1,2],[4,11,4,0,2],[10,4,0,4,2]]


problems.append([0,0,1,0,1])
problems.append([0,0,0,1,1])

problems.sort(key=lambda x:(x[0]+x[1],-(x[2]+x[3]),x[4]))
print(problems)

answer=0
time=0
maxa=0
maxb=0

for problem in problems:
    a,b,ar,br,cost=problem
    if maxa<a:
        maxa=a
    if maxb<b:
        maxb=b

answer=math.inf

def dfs():
    for prob in problems:
        if a>=prob[0] and b>=prob[1]:
            a+=prob[2]
            b+=prob[3]
            time+=prob[4]

    print()

