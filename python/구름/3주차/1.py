n = int(input())
arr=list(map(int,input().split()))

s=set()
for i in arr:
	if abs(i) in s:
		s.remove(abs(i))
	else:
		s.add(i)

print(sum(s))