# jobs=[[1, 5, 2, 3], [2, 2, 3, 2], [3, 1, 3, 3], [5, 2, 1, 5], [7, 1, 1, 1], [9, 1, 1, 1], [10, 2, 2, 9]]
jobs=[[0, 2, 3, 1], [5, 3, 3, 1], [10, 2, 4, 1]]


#현재 문제: finishTime<=request 에서 이전에 일이 끝나도 request보다 작은 경우를 생각해야함, 모든 일이 끝나고 남은것들을 다 처리해야함
#115

from collections import defaultdict

def solution(jobs):
    answer = [jobs[0][2]]
    dic=defaultdict(int)
    
    timdDic=defaultdict(int)

    finishTime=0
    number=0


    for job in jobs:
        request, time, num, impo=job
        

        
        
        print(job)
        print(finishTime,number)
        flag=False

        if finishTime<=request: #요청시간이 finishtime을 지났으면 finsihtime일 때의 행동을 먼저 해준다

            if not dic:
                finishTime=request+time
                number=num
                
                if answer[-1]!=num:
                    answer.append(num)
                
                continue

            if finishTime==request:
                if num==number:
                    finishTime=finishTime+time #끝날 시간에 더함
                    print("aaa2",number,finishTime)
                    continue
                flag=True
                dic[num]+=impo
                timdDic[num]+=time


            while(finishTime<=request):
                print(dic)
                if not dic:
                    break
                arr=sorted(dic.items(),key=lambda x:(-x[1],x[0]))
                key,value=arr[0]
                number=key
                finishTime+=timdDic[key]
                if answer and answer[-1]!=key: 
                    answer.append(key)
                del dic[key]
                del timdDic[key]

        if not flag:
            if num==number:
                
                finishTime=finishTime+time #끝날 시간에 더함
                print("aaa",number,finishTime) 
            else:
                if request != finishTime:
                    dic[num]+=impo
                    timdDic[num]+=time

        
        print(dic)


    if dic:
        arr=sorted(dic.items(),key=lambda x:(-x[1],x[0]))

        for a in arr:
            key,v=a
            if answer and answer[-1]!=key:
                answer.append(key)

    
    return answer

print(solution(jobs))