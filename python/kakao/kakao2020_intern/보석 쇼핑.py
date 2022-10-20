gems=["XYZ", "XYZ", "XYZ"]

n=len(gems)
total = len(set(gems)) 
dic={gems[0]:1}

start = 0 
end = 0

minn=n+1
answer=[0,0]


while end < n:

    if(len(dic)==total):
        print(start,end)
        if(minn>end-start):
            minn=end-start
            answer[0]=start+1
            answer[1]=end+1


        start+=1
        if(start>=end):
            break
        while start<end :
            print(start,end)
            if(dic[gems[start-1]]==1):
                del dic[gems[start-1]]
            else:
                dic[gems[start-1]]-=1
            
            if(len(dic)==total):
                if(minn>end-start):
                    minn=end-start
                    answer[0]=start+1
                    answer[1]=end+1
            else:
                break
            
            start+=1
    
    else:
        print(start,end)
        end+=1
        if(end==n):
            break
        dic[gems[end]] = dic.get(gems[end], 0) + 1



print(answer)
        
