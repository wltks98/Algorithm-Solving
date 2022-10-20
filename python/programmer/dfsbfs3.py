from collections import deque
from tempfile import tempdir


begin="hit"
target="cog"
words=["hot", "dot", "dog", "lot", "log", "cog"]

def check(a,b):

    count=0

    for i in range(len(a)):
        if not a[i] == b[i]:
            count+=1
        
        if count==2:
            return False
    
    if count==1:
        return True
    else:
        return False


q=deque()
q.append([begin,[]])

if not target in words:
    answer=0


while q:
    start,visited=q.popleft()
    for word in words:
        if check(start,word) and (word not in visited):
            if word==target:
                return len(visited)+1
                

            temp=visited[0:]
            temp.append(word)
            q.append([word,temp])


print(answer)