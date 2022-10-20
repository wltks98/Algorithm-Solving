from typing import Set


n=4
costs=[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]


costs.sort(key=lambda x: (x[2]))

s=set([costs[0][0],costs[0][1]])


answer=0

while len(s) !=n:
    for cost in costs:
        a,b,w=cost

        if(a in s and b in s):
            continue

        if(a in s or b in s):
            s.update([a,b])
            answer+=w
            break

print(answer)