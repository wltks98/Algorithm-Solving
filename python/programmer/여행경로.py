from collections import defaultdict


tickets=[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
dic=defaultdict(list)
visited=defaultdict(list)

n=len(tickets)

answer=[]

for ticket in tickets:
    a,b=ticket
    dic[a].append(b)
    visited[a].append(False)


def dfs(start,path):
    print(start,path)
    if(len(path)==n+1):
        answer.append(path)
        return

    for i in range (len(dic[start])):
        if(not visited[start][i]):
            visited[start][i]=True
            dfs(dic[start][i],path+[dic[start][i]])
            visited[start][i]=False

    return

for i in range(len(dic["ICN"])):
        visited["ICN"][i] = True
        dfs(dic["ICN"][i], ["ICN", dic["ICN"][i]])
        visited["ICN"][i] = False

answer.sort()
print(answer)