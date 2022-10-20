board=[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
move=[1,5,3,5,1,2,1,4]

n=len(board)

stack=[-1]

answer=0

for m in move:
    m-=1
    for i in range(n):
        if board[i][m]==0:
            continue
        else:
            s=stack[-1]
            if board[i][m]==s:
                stack.pop()
                answer+=2
            else:
                stack.append(board[i][m])
            board[i][m]=0

            break


print(answer)