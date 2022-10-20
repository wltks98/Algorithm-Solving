from collections import defaultdict
from bisect import bisect_left

info=["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
query=["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]



dic=defaultdict(list)


for inf in info:
    arr=inf.split()
    for i in [arr[0],"-"]:
        for j in [arr[1],"-"]:
            for k in [arr[2],"-"]:
                for l in [arr[3],"-"]:
                    dic[i+" and "+j+" and "+k+" and "+l].append(int(arr[4]))

for value in dic.values():
        value.sort()

answer=[]
for q in query:
    arr=q.split()
    s=" ".join(arr[:-1])
    num=int(arr[-1])
    arr2=dic[s]
    index=bisect_left(arr2,num)
    answer.append(len(arr2)-index)

print(answer)