s="001100011"


count=[]

c=1
now=s[0]

answer=0

for i in range(1, len(s)):
    if(now==s[i]):
        c+=1
    else:
        count.append(c)
        now=s[i]
        c=1

count.append(c)
    
for i in range(1,len(count)):
    a=count[i-1]
    b=count[i]
    if(a<b):
        answer+=a
    else:
        answer+=b

print(answer)
# for a in s:


#     if not stack:
#         stack.append(a)
#         change=0
#     elif(stack[-1]!=a):
#         if(change==0):
#             stack.append(a)
#             change=1
#         else:
#             if(len(stack)%2==1):
#                 stack.clear()

#             elif(stack.count('0')==stack.count('1')):
#                 answer+=stack.count('0')
#                 stack.clear()
#             else:
#                 stack.clear()

#             stack.append(a)
#             change=0
#     else:
#         stack.append(a)
        

# print(answer)
        