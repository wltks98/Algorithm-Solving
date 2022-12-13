room=[3,4,2,4]

def find(x, parent):

    if parent[x]!=x:
        return find(parent[x], parent)
    return x

def union(x,y, parent):
    x=find(x, parent)
    y=find(y, parent)

    if x<y:
        parent[y]=x
    else:
        parent[x]=y

def solution(rooms):

    n=len(rooms)

    parent=[0]+[i for i in range(1,n+1)]

    
    for i, room in enumerate(rooms):
        union(i+1, room, parent)
        

    s=set(parent)
    countSet=len(s)-1
    print(parent)
    return countSet-1 if countSet!=1 else 1

print(solution(room))
