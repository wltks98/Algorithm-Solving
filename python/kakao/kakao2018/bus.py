n=10
t=60
m=45
timetable=["23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"]


def cal(time,add):

    h,m=map(int,time.split(':'))
    total=h*60+m+add
    h=total//60
    m=total%60

    if h<10:
        if m<10:
            return '0'+str(h)+':0'+str(m)
        else:
            return '0'+str(h)+':'+str(m)
    else:
        if m<10:
            return str(h)+':0'+str(m)
        else:
            return str(h)+':'+str(m)

timetable.sort()


now="09:00"
count=0
for time in timetable:
    if now>=time:
        count+=1
    if count==m:
        answer=cal(time,-1)
        break
if count<m:
    answer=now

timetable=timetable[count:]


for i in range(n-1):
    now=cal(now,t)
    count=0
    for time in timetable:

        if now>=time:
            count+=1
        if count==m:
            answer=cal(time,-1)
            break
        
    if count<m:
        answer=now

    timetable=timetable[count:]
print(answer)