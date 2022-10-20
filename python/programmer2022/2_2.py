import math


rooms=["[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"]
target=403

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
    if abs(num-target) not in dic:
        dic[abs(num-target)]=[]

    for i in range(1,len(r)):
        if r[i] in dele:
            continue
        dic[abs(num-target)].append(r[i])
    
array=dict(sorted(dic.items(),key=lambda x:x[0]))





print(dic)
print(array)


