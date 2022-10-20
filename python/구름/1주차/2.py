n,name = input().split()
answer=0
for i in range(int(n)):
	ch=input()
	if name in ch:
		answer+=1

print(answer)