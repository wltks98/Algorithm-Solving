n=3
words=["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]

answer=[0,0]

arr=[]

arr.append(words[0])

for i in range(1,len(words)):
    num=i%n
    if words[i] in arr:
        answer[0],answer[1]=num+1,i//n+1
        break
    if words[i][0] !=words[i-1][-1]:
        answer[0],answer[1]=num+1,i//n+1
        break
    arr.append(words[i])

print(arr)
print(answer)
    
