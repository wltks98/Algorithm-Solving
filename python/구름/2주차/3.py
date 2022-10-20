
n,k = list(map(int,input().split()))
arr=[]

for i in range (n):
	name, height= input().split()
	arr.append((name,float(height)))
	
arr.sort(key=lambda x:(x[0],x[1]))


answer=arr[k-1][0]+" "+"{:.2f}".format(arr[k-1][1])
print(answer)