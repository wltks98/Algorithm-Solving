n=input()
user_input = list(map(int,input().split()))
answer=1
for i in user_input:
	answer*=i

print(answer)