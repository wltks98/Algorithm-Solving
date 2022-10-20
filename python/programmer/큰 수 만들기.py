number="4177252841"
k=4

stack=[number.pop(0)]

for i in number:
    if stack[-1]<i:
        while stack and stack[-1]<i and k>0:
            stack.pop()
            k-=1
        
    elif k==0 or stack[-1]>=i:
        stack.append(i)

if k :
    stack=stack[:-k]


    