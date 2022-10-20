atmos=[[140, 90], [177, 75], [95, 45], [71, 31], [150, 30], [80, 35], [72, 33], [166, 81], [151, 75]]


mask=0
day=0

for atm in atmos:
    a,b=atm
    status=0
    if a>=151 and b>=76:
        status=2 #모두 매우 나쁨
    elif a>=81 or b>=36:
        status=1

    
    
    if status==1:
        if day==0: #쓰던게 없음
            mask+=1
            day+=1
        elif day<=2: #쓰던게 있으면 쓴다
            day+=1
        
        
    elif status==0: #쓰던게 있으면 날짜만 더함
        if day>0:
            day+=1
    else: #모두 나쁜날
        if day==0: #마스크 쓰던게 없음
            mask+=1
            day=0
        else: #마스크 쓰던게 있으면 day 초기화
            day=0

    if day>=3:
        day=0

    print(status,':',mask,day)
            
print(mask)