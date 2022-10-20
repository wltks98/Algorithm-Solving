from collections import defaultdict


maps=["XY..", "YX..", "..YX", ".AXY"]

n=len(maps) #세로
m=len(maps[0]) #가로

visited=[[False for _ in range(m)] for _ in range(n)]

total_dic=defaultdict(int)

dx=[0,0,1,-1]
dy=[1,-1,0,0]

def dfs(x,y,dic):


    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]

        if not (nx>=0 and nx<m and ny>=0 and ny<n):
            continue
        if(maps[ny][nx]=="." or visited[ny][nx]):
            continue
        
        visited[ny][nx]=True
        dic[maps[ny][nx]]+=1
        dfs(nx,ny,dic)


    return

def cal(dic):
    print(dic)
    dic2=sorted(dic, key=lambda x:(dic[x],x), reverse=True)

    winner=dic2[0]

    index=len(dic2)

    for i in range(1,len(dic2)):
        if(dic[winner]!=dic[dic2[i]]):
            index=i
            break
        else:
            total_dic[dic2[i]]+=dic[dic2[i]]
    
    count=dic[winner]
    for i in range(index,len(dic2)):
        count+=dic[dic2[i]]

    total_dic[winner]+=count
    
    return 

mini_dic=defaultdict(int)



for i in range(m):
    for j in range(n):
        if not visited[j][i] and not maps[j][i]==".":
            visited[j][i]=True
            mini_dic[maps[j][i]]+=1
            dfs(i,j,mini_dic)
            cal(mini_dic)

            mini_dic=defaultdict(int)

print(total_dic)
answer=sorted(total_dic, key=lambda x:(-total_dic[x]))

print(total_dic[answer[0]])