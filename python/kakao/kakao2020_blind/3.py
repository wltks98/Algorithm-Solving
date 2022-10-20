from tabnanny import check


key=[[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock=[[1, 1, 1], [1, 1, 0], [1, 0, 1]]

m=len(key)
n=len(lock)

pad=m-1
padding=[[0]*(m+2*pad) for _ in range(m+2*pad)]

for i in range(m):
    for j in range(m):
        padding[i+pad][j+pad]=lock[i][j]

for p in padding:
    print(p)

def rotate(arr):
    ar=[[0]*m for _ in range(m)]
    for i in range(m):
        for j in range(m):
            ar[j][m-1-i] = key[i][j]
    return ar

for i in range(4):
    for j in range(m+2*pad):
        for k in range(m+2*pad):
            check()