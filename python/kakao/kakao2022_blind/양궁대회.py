n=5
info=[2,1,1,1,0,0,0,0,0,0,0]

answer=[0 for _ in range(11)]
arrow=[0 for _ in range(11)]
maxi=0

for subset in range(1<<10):
    ryan=0
    apeach=0
    count=0

    for i in range(10):
        if subset & (1<<i):
            ryan+=10-i
            arrow[i]=info[i]+1
            count+=info[i]+1
        else:
            arrow[i]=0
            if info[i]!=0:
                apeach+=10-i
    
    if count>n:
        continue
    
    arrow[10]=n-count

    if ryan-apeach>maxi:
        maxi=ryan-apeach
        answer=arrow[:]
    elif ryan-apeach<maxi:
        continue
    else:
        for i in reversed(range(11)):
            if arrow[i] > answer[i]:
                answer=arrow[:]
                break
            elif arrow[i] < answer[i]:
                break
            else:
                continue

if maxi==0:
   answer=[-1]

