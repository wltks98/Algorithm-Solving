
t = int(input())
for i in range(t):
	n=int(input())
	arr=list(map(int,input().split()))
	average=sum(arr)/n
	count=0
	for a in arr:
		if a >=average:
			count+=1
	
	print(str(count)+"/"+str(n))