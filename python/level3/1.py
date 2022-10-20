import heapq

tickets=[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","AAA"]]

n=len(tickets)

dic={}

answer=[]

for t in tickets:
    a,b=t
    if a in dic:
        heapq.heappush(dic[a],b)
    else:
        dic[a]=[b]

def dfs(start):



    if (start not in dic) or not dic[start]:
        answer.append(start)
        return

    while dic[start]:
        dfs(heapq.heappop(dic[start]))
    
    
dfs("ICN")


print(answer)