
n = int(input())
s=input()
ch=s[0]
count=1
for i in s:
	if ch!=i:
		count+=1
		ch=i
		
print(count)