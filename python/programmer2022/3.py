line="Q4OYPI"

arr=['Q','W','E','R','T','Y','U','I','O','P']

dic={arr[i-1]:i for i in range(1,11)}

answer=[]
left=[1,0]
right=[10,0]

for ch in line:
    if ch in dic: #문자
        x=dic[ch]
        y=0
    else:
        x=int(ch)
        if x==0:
            x=10
        y=1

    disl=abs(left[0]-x)+abs(left[1]-y)
    disr=abs(right[0]-x)+abs(right[1]-y)

    if disl<disr:
        left=x,y
        answer.append(0)
    elif disl>disr:
        right=x,y
        answer.append(1)
    else:
        hl=abs(left[0]-x)
        hr=abs(right[0]-x)
        if hl<hr:
            left=x,y
            answer.append(0)
        elif hl>hr:
            right=x,y
            answer.append(1)
        else:
            if x<=5:
                left=x,y
                answer.append(0)
            else:
                right=x,y
                answer.append(1)

print(answer)
