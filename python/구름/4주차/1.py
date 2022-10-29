
n,m = list(map(int,input().split()))

q=[]

for i in range(m):
	a,b=input().split()
	b=int(b)
	if (a=="deposit"):
		n+=b
	
	elif a=="pay":
		if n>=b:
			n-=b
	else:
		q.append(b)
			
	
	while q:
		if n>=q[0]:
				n-=q[0]
				q.pop(0)
		else:
				break
	

			
while q:
		if n>=q[0]:
				q.pop(0)
		else:
				break
		
		
print(n)