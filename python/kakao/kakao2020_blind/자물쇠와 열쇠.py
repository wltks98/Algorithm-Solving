def attach(x, y, m, key, arr):
    for i in range(m):
        for j in range(m):
            arr[x+i][y+j] += key[i][j]

def rotate(arr):
    return list(zip(*arr[::-1]))


def detach(x, y, M, key, board):
    for i in range(M):
        for j in range(M):
            board[x+i][y+j] -= key[i][j]


def check(arr, m, n):
    for i in range(n):
        for j in range(n):
            if arr[m+i][m+j] != 1:
                return False;
    return True

def solution(key, lock):
    m=len(key)
    n=len(lock)
    
    
    arr=[[0 for _ in range(n+m*2)] for _ in range(n+m*2)]
    
    for i in range(n):
        for j in range(n):
            arr[i+m][j+m]=lock[i][j]
    
    new_key = key
    for _ in range(4):
        new_key=rotate(new_key)
        for x in range(1, n+m):
            for y in range(1, n+m):
                attach(x, y, m, new_key, arr)
                if check(arr,m,n):
                    return True
                detach(x,y,m,new_key,arr)
    
    return False