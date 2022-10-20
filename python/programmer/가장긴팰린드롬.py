s="abcdcba"

n=len(s)
answer=0
for i in range(n):
    for j in range(i+1,n+1):
        if(s[i:j]==s[j-1:i-1:-1]):
            if(answer<j-i):
                answer=j-i

print(s[0:2])
print(s[2:0:-1])