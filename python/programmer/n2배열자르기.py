n=1
left=0
right=0

arr=[]

for i in range(left,right+1):
    r=(i)//n
    c=(i)%n


    a=r+1 if r>=c else c+1

    arr.append(a)

print(arr)

    