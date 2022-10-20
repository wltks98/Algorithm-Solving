import heapq

tickets=[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","AAA"]]


dic={}
answer=[]

for t in tickets:
    a,b=t
    if a in dic:
        heapq.heappush(dic[a],b)
    else:
        dic[a]=[b]



def dfs(path):

    while path:
        start=path[-1]

        if (start not in dic) or not dic[start]:
            answer.append(path.pop())

        else:
            path.append(dic[start].pop())
              
    return

dfs(["ICN"])


print(answer[::-1])