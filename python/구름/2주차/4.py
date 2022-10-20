n,k=list(map(int,input().split()))
count=0

for i in range(k):
	a,b=list(map(int,input().split()))
	
	if(n>=3):
		if (a==1 and b==1) or (a==1 and b==n) or (a==n and b==1) or (a==n and b==n):
			count+=3
		elif a==1 or a==n or b==1 or b==n:
			count+=4
		else:
			count+=5
	elif n==1:
		count+=1
	elif n==2:
		count+=3

print(count)