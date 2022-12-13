def getKoreaTimeHour(time):
    h,m,s=time.split(":")
    
    return (int(h)+ 9)%24

def solution(logs):
    answer = [0 for _ in range (24)]

    time=logs.split()
    for i in range(1,len(time),2):
        answer[getKoreaTimeHour(time[i])]+=1

    return answer