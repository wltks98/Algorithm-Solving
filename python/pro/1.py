def solution(n, cores):
    core_len=len(cores)

    left=1
    right=max(cores)*n//core_len

    n-=core_len #이전 시도에 비해 이걸 왜 넣었냐? 왠지 모르게 계속 안돼서 count+=mid//core+1 형식으로 하니깐 복잡해서 그냥 처음부터 넣는건 빼버림


    while left<right:

        mid=(left+right)//2

        count=0
        for core in cores:
            count+=mid//core

        if count>=n:
            right=mid

        else:
            left=mid+1


    count=0

    for core in cores:
        count+=(right-1)//core #우선 완료한 만큼 갯수를 새고

    for i,v in enumerate(cores): #완료한 것중 나머지가 0이면 갯수를 증가시킴
        if right%v ==0:
            count+=1

            if count==n:
                return i+1