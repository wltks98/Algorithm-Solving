s="{{1,2,3},{2,1},{1,2,4,3},{2}}"

arr=s[1:-1]

dic={}
num=''
for a in arr:
    if a=='{':
        continue
    elif a=='}':
        if num:
            if num in dic:
                dic[num]+=1
            else:
                dic[num]=1
        
            num=''

    elif a!=',':
        num+=a
    else:
        if num:
            if num in dic:
                dic[num]+=1
            else:
                dic[num]=1
            
            num=''

dic=sorted(dic, key= lambda x : dic[x],reverse=True)

answer=[]
for d in dic:
    answer.append(int(d))

print(answer)

