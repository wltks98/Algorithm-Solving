import sys
sys.setrecursionlimit(10**6)

k=10
room_number=[1,3,4,1,3,1]

dic={}

answer=[]

def dfs(num):
    if num not in dic:
        dic[num]=num+1
        return num
    else:
        dic[num]=dfs(dic[num])
    return dic[num]


for num in room_number:
    answer.append(dfs(num))

print(answer)