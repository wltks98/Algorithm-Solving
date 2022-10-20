nodeinfo=[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]
n=len(nodeinfo)
dic={node[0]:i+1 for i,node in enumerate(nodeinfo)} #x로 노드 번호 찾기

dicy={node[1]:[]for node in nodeinfo} # 층별 노드의 x 저장

nodes=sorted(nodeinfo,key=lambda x:(-x[1],x[0])) 
nodes2=sorted(nodeinfo,key=lambda x:(x[1],x[0])) 
for node in nodes:
    x,y=node
    dicy[y].append(x)



tree=[[]for _ in range(n)]

for node in nodes2:
    x,y=node
    h=y
    while ():
        h+=1
        if h in dicy:
            


print(dicy)




