import math


rooms=["[101]Azad,Guard", "[202]Guard", "[303]Guard,Dzaz"]
target=202

dic={}
arr={}
dele=[]

for room in rooms:
    r=room.replace(']',',').split(',')
    num=int(r[0][1:])



    if num==target:
        for i in range(1,len(r)):
            dele.append(r[i])
        continue
    
    for i in range(1,len(r)):
        if r[i] in dic:
            dic[r[i]].append(num)
            #arr[r[i]][0]+=1
        else:
            dic[r[i]]=[num]
            #arr[r[i]]=[1]

for i in dic:

    if i in dele:
        continue

    room=dic[i]

    arr[i]=[len(room)]
    
    minn=math.inf
    for r in room:
        dif=abs(target-r)
        if dif<minn:
            minn=dif
    arr[i].append(minn)
    arr[i].append(i)

# array=dict(sorted(arr.items(),key=lambda x:x[1]))
array=sorted(arr,key=lambda x:dic[x])

print(list(array.keys()))


print(array)



print(arr)


print(dic)


