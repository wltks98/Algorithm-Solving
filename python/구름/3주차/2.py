
n = int(input())
arr=input()
dic={"1":"1.,?!","2":"2ABC","3":"3DEF","4":"4GHI","5":"5JKL",
		 "6":"6MNO","7":"7PQRS","8":"8TUV","9":"9WXYZ"}

answer=""

num="0"
count=0
for i in arr:
	if num!=i:
		if num!="0":
			if count>=len(dic[num]):
				count=count%len(dic[num])
			answer+=dic[num][count]
		num=i
		count=0
	else:
		count+=1
if count>=len(dic[num]):
				count=count%len(dic[num])
answer+=dic[num][count]
print(answer)