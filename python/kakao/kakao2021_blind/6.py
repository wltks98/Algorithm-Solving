board=[[1,0,0,3],[2,0,0,0],[0,0,0,2],[3,0,1,0]]
r=1
c=0



def right(x,y):

    if(y<4):
        y+=1
    while board[x][y]==0:
        if(y<4):
            y+=1
        else:
            break
            
    return x,y

def left(x,y):

    if(y>=0):
        y-=1
    while board[x][y]==0:
        if(y>=0):
            y-=1
        else:
            break
            
    return x,y

def up():
    if(x>=0):
        x-=1
    while board[x][y]==0:
        if(x>=0):
            x-=1
        else:
            break
            
    return x,y

def down():
    if(x<4):
        x+=1
    while board[x][y]==0:
        if(x<4):
            x+=1
        else:
            break
            
    return x,y


zero=0
for i in range(4):
    zero+=board[i].count(0)

pair=(16-zero)//2



arr=[right,left,up,down]
q=[(r,c,0,board[r][c])]
while q:
    x,y,cost,card=q.pop()

    for i in range(4):
        nx,ny=arr[i](x,y)

        if(nx==x and ny==y):
            continue


        if board[nx][ny]!=0:
            if board[nx][ny]==card:
                cost+=1
                pair-=1
                card=0
            else:
                card=board[nx][ny]
        
        q.append((r,c,cost+1,card))

