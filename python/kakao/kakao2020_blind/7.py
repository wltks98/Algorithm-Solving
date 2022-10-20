board=[[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]
n=len(board)

new_board = [[1]*(n+2) for _ in range(n+2)]
for i in range(1, n+1):
    for j in range(1, n+1):
        new_board[i][j] = board[i-1][j-1]

q=[]

dx=[1,-1,0,0]
dy=[0,0,1,-1]

q.append([(0,0),(0,1),0])

while q:
    d1,d2,cost=q.pop()
    x1,y1=d1
    x2,y2=d2

    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
