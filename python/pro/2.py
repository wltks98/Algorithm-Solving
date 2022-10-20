user_id=["frodo", "fradi", "crodo", "abc123", "frodoc"]
banned_id=["fr*d*", "abc1**"]

dic ={}
n=len(banned_id)

for i,bid in enumerate(banned_id):
    for j,uid in enumerate(user_id):
        if len(bid)==len(uid):
            flag=True
            for a,b in zip(bid,uid):
                if a==b or a=='*':
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
arr=[]

def dfs(num,visit):
    global count

    if num==n:
        if visit not in arr:
            count+=1
            arr.append(visit)
        return

    for a in dic[num]:
        if not visit & 1<<a :
            dfs(num+1,visit|1<<a)



dfs(0,0)

print(count)


# count=0
# arr=[]
# def dfs(num,visit,n,dic):
#     global count

#     if num==n:
#         if visit not in arr:
#             count+=1
#             arr.append(visit)
#         return

#     for a in dic[num]:
#         if not visit & 1<<a :
#             dfs(num+1,visit|1<<a,n,dic)

# def solution(user_id, banned_id):
#     dic ={}
#     n=len(banned_id)

#     for i,bid in enumerate(banned_id):
#         for j,uid in enumerate(user_id):
#             if len(bid)==len(uid):
#                 flag=True
#                 for a,b in zip(bid,uid):
#                     if a==b or a=='*':
#                         continue
#                     else:
#                         flag=False
#                         break

#                 if flag:
#                     if i in dic:
#                         dic[i].append(j)
#                     else:
#                         dic[i]=[j]
                        
                            
    
#     dfs(0,0,n,dic)
#     return count

