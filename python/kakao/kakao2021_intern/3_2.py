n=8
k=2
cmd=["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]

dic={i:[i-1,i+1] for i in range(n)}
OX = ["O" for i in range(n)]

delete=[]

now=k

for str in cmd:
    if str[0]=='C':
        

        pre,ne=dic[now]
        delete.append([pre,ne,now])
        OX[now] = "X"

        if ne==n:
            now=dic[now][0]
        else:
            now=dic[now][1]

        if pre==-1:
            dic[ne][0]=pre
        elif ne==n:
            dic[pre][1]=n
        else:
            dic[pre][1]=ne
            dic[ne][0]=pre


    elif str[0]=='Z':
        pre,ne,a=delete.pop()
        OX[a] = "O"

        if pre==-1:
            dic[ne][0]=a
        elif ne==n:
            dic[pre][1]=a
        else:
            dic[pre][1]=a
            dic[ne][0]=a

    elif str[0]=='D':
        for _ in range(int(str[2:])):
                now = dic[now][1]
    elif str[0]=='U':
        for _ in range(int(str[2:])):
                now = dic[now][0]

print("".join(OX))