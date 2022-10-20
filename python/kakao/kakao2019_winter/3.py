user_id=["frodo", "fradi", "crodo", "abc123", "frodoc"]
banned_id=["fr*d*", "*rodo", "******", "******"]

dic={}
n=len(banned_id)

for i,bid in enumerate(banned_id):
    for j,uid in enumerate(user_id):
        if len(bid)==len(uid):
            flag=True 
            for a,b in zip(uid,bid):
                if a==b or b=='*':
                    continue
                else:
                    flag=False
                    break
                    
            if flag:
                if i in dic:
                    dic[i].append(j)
                else:
                    dic[i]=[j]
                    


count=0
s=[]
def dfs(num,bit):
    global count

    if num==n:
        if bit not in s:
            count+=1
            s.append(bit)
        return

    for a in dic[num]:
        if bit | 1<<a !=bit:
            dfs(num+1,bit|1<<a)


dfs(0,0)

print(dic)

print(count)