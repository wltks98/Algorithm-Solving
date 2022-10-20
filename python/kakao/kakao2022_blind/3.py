import math


fees=[180, 5000, 10, 600]
records=["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]


time={}
answer=[]

def cal_time(a,b):
    ah,am=map(int,a.split(':'))
    bh,bm=map(int,b.split(':'))

    

    return ah*60+am-bh*60-bm



for record in records:
    a,b,c=record.split(' ')
    if b in time:
        time[b].append((a,c))
    else:
        time[b]=[(a,c)]

dic=dict(sorted(time.items()))
print(dic)

for num in dic:
    arr=dic[num]

    t="00:00"
    total_time=0
    inorout='IN'
    cost=0

    print(arr)
    for a in arr:
        if a[1]=='IN':
            t=a[0]
            inorout='IN'
        else:
            inorout='OUT'
            total_time+=cal_time(a[0],t)

    if inorout=='IN':
        total_time+=cal_time("23:59",t)

    if total_time<=fees[0]:
        cost=fees[1]
    else:
        cost=fees[1]+math.ceil((total_time-fees[0])/fees[2])*fees[3]
    answer.append(cost)

print(answer)