operations = ['push 4', 'pop', 'push 3', 'push 5', 'push 2', 'inc 3 1', 'pop', 'push 1', 'inc 2 2', 'push 4', 'pop', 'pop']

stack=[]
for op in operations:
    op=list(op.split())
    if(op[0]=='push'):
        stack.append(int(op[1]))

    elif(op[0]=='pop'):
        stack.pop()


    else:
        a=int(op[1])
        b=int(op[2])

        for i in range(a):
            stack[i]+=b
        
    if(stack):
        print(stack[-1])
    else:
        print("EMPTY")

