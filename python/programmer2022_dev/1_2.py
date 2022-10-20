# registered_list=["card","ace13","ace16","banker","ace17","ace14"]
from collections import defaultdict


registered_list=["bird99","bird98","bird101","gotoxy"]
new_id="bird98"

arr=[str(i) for i in range(10)]

dic=defaultdict(list)

for regist in registered_list:

    flag=False

    if(len(regist)!=3):
        for i in range(3,len(regist)):
            if(regist[i] in arr):
                dic[regist[:i]].append(int(regist[i:]))
                flag=True
                break
    
    if not flag:
        dic[regist].append(0)
    


if(new_id in registered_list):

    prefix=new_id
    for i in range(3,len(new_id)):
        if(new_id[i] in arr):
            prefix=new_id[:i]
            break
    

    arr=dic[prefix]
    arr.sort()

    

    num=arr[0]

    while num in arr:
        num+=1

answer=prefix+str(num)

print(answer)

    
                




