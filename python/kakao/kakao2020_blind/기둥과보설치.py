n=5
build_frame=[[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]

answer=[]
s=set()

def check():
    for r in s:
        x,y,a=r
        if a==0: #기둥
            if(y!=0 and (x,y-1,0) not in s and (x-1,y,1) not in s and (x,y,1) not in s):
                return False
        else:
            if((x,y-1,0) not in s and (x+1,y-1,0) not in s and not ((x-1, y, 1) in s and (x+1, y, 1) in s)):
                return False
    return True
for build in build_frame:
    x,y,a,b=build

    if b==1: #설치
        s.add((x,y,a))
        if not check():
            s.remove((x,y,a))
    else:
        s.remove((x,y,a))
        if not check():
            s.add((x,y,a))

answer = map(list, s)

answer.sort(key=lambda x:(x[0], x[1], x[2]))