numbers=[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand="right"

answer=""

left=10 
right=12

dict={i:[(i-1)%3,(i-1)//3] for i in range(1,13)}
dict[0]=dict[11]

for num in numbers:
    if(num in [1,4,7]):
        answer+='L'
        left=num
    elif(num in [3,6,9]):
        answer+='R'
        right=num
    else:
        lx,ly=dict[left]
        rx,ry=dict[right]
        nx,ny=dict[num]

        n=abs(nx-lx)+abs(ny-ly)-(abs(nx-rx)+abs(ny-ry))

        if(n>0):
            answer+='R'
            right=num
        elif(n<0):
            answer+='L'
            left=num
        else:
            if(hand=="right"):
                answer+='R'
                right=num
            else:
                answer+='L'
                left=num


print(answer)