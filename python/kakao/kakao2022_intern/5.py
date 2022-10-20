rc=[[1, 2, 3], [4, 5, 6], [7, 8, 9]]
operations=["Rotate", "ShiftRow"]

n=len(rc)

def rotate(rc):
    for i in range(n):
        for j in range(n):
            if i==0:
                if j==0:
                    rc[i][j]==rc[i+1][j]
                else:
                    rc[i][j]==rc[i][j-1]
            elif i==n-1:
                if j==n-1:
                    rc[i][j]==rc[i-1][j]
                else:
                    rc[i][j]==rc[i][j+1]
            else:
                if j==0:
                    rc[i][j]==rc[i+1][j]
                else:
                    rc[i][j]==rc[i-1][j]
    return rc
                    

def shift(rc):
    for i in range(n):
        for j in range(n):
            if i==0:
                rc[i][j]==rc[n-1][j]
            else:
                rc[i][j]==rc[i-1][j]
    return rc

for oper in operations:
    if oper=="Rotate":
        rc=rotate(rc.copy())
    else:
        rc=shift(rc.copy())

print(rc)