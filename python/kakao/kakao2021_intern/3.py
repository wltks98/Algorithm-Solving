def solution(n, k, cmd):
    answer = ''

    linked_list = {i: [i - 1, i + 1] for i in range(1, n+1)} #n=8일때 1~8까지
    OX = ["O" for i in range(1,n+1)]
    stack = []

    k += 1

    for c in cmd:
        if c[0] == 'D':
            for _ in range(int(c[2:])):
                k = linked_list[k][1]
        elif c[0] == 'U':
            for _ in range(int(c[2:])):
                k = linked_list[k][0]

        elif c[0] == 'C':
            prev, next = linked_list[k]
            stack.append([prev, next, k])
            OX[k-1] = "X"

            if next == n+1:
                k = linked_list[k][0] #마지막이면 이전으로
            else:
                k = linked_list[k][1] #마지막이 아니면 다음으로

            if prev == 0: #삭제한 노드가 0번 노드라면 (처음에 번호에 1씩 더했으므로 prev가 0)
                linked_list[next][0] = prev
            elif next == n+1: #삭제한 노드가 n번 노드라면
                linked_list[prev][1] = next
            else:
                linked_list[prev][1] = next
                linked_list[next][0] = prev

        elif c[0] == 'Z':
            prev, next, now = stack.pop()
            OX[now-1] = "O"

            if prev == 0:
                linked_list[next][0] = now
            elif next == n+1:
                linked_list[prev][1] = now
            else:
                linked_list[prev][1] = now
                linked_list[next][0] = now

    return "".join(OX)

#요건 내풀이 (실패함)

# n=8
# k=2
# cmd=["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]



# class linkedlist:

#     def __init__(self,num):
#         self.l= nodes[num-1] if (num-1>=0) else nodes[n-1]
#         self.r=nodes[num+1] if(num<=n-1) else nodes[0]
#         self.num=num

#     def move(self,direct,distance):
#         if direct=='D':
#             node=self
#             for _ in range(distance):
#                 node=node.r
#             return node
#         else:
#             node=self
#             for _ in range(distance):
#                 node=node.l
#             return node

#     def remove(self):
     
#         if(self.r.num<self.num):    #오른쪽이 자기보다 작다는건 오른쪽이 맨처음으로 가는 즉, 현재가 리스트의 마지막 
#             next_num=self.l.num     
#         else:
#             next_num=self.r.num

#         self.l.r=self.r
#         self.r.l=self.l

#         self.l=None
#         self.r=None

#         return self.num, next_num

#     def add(self, pos):

#         self=nodes[pos]
#         node=nodes[pos]

#         while(node.r !=None ):
#             pos-=1
#             node=nodes[pos]

#         node.r.l=self
#         self.r=node.r
#         node.r=self
#         self.l=node
            

        



# nodes=[linkedlist(i) for i in range(n)]
# arr=["O" for _ in range(n)]



# last=len(arr)

# stack=[]

# now=nodes[k]

# for i in range(n):
#     cm=cmd[i]

#     if(cm[0]=='C'):
        
#         s,next_num=now.remove()

#         stack.append(s)
#         now=nodes[next_num]
#         arr[s]="X"

#     elif(cm[0]=='Z'):
#         num=stack.pop()
#         now.add(num)
#         arr[num]="O"

#     else:
#         now=now.move(cm[0],cm[2])

# print(arr)