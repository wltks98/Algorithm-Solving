from msvcrt import kbhit


id_list=["con", "ryan"]
report=["ryan con", "ryan con", "ryan con", "ryan con"]
k=2

answer=[]
dic={id:0 for id in id_list}
dic2={id:[] for id in id_list}

for re in report:
    a,b=re.split()
    if b not in dic2[a]:
        dic[b]+=1
        dic2[a].append(b)

for id in id_list:
    count=0
    for a in dic2[id]:
        if dic[a]>=k:
            count+=1
    answer.append(count)
print(dic)
print(dic2)
print(answer)