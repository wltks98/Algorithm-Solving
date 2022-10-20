import math


n=5
info=[2,1,1,1,0,0,0,0,0,0,0]


need=[i+1 for i in info]

q=[]
answer=[0 for _ in range(11)]


maxi=-1


def dfs(start,score,arrow,arr):

    global answer
    global maxi


    if arrow==0:
        if score>=maxi:
            maxi=score
            answer=arr
            
        return


    for i in range(start,11):
        if need[i]<=arrow:
            arr[i]=need[i]
            dfs(i,score+10-i,arrow-need[i],arr)
            

for i in range(11):
    
    if need[i]<=n:
        arr=[0 for _ in range(11)]
        arr[i]=need[i]
        dfs(i,10-i,n-need[i],arr)
        

print(answer)
