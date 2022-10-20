n=int(input())
arr= list(map(int,input().split()))

def check(n):
    arr=[True]*(n+1) 
    arr[0]=False
    arr[1]=False

    for i in range(2, n+1):
        if arr[i]: 
            j=2
            while i*j<=n:
                arr[i*j]=False
                j+=1

    return arr

prime = check(n) 
answer=0
for i,value in enumerate(arr):
    if prime[i+1]:
        answer+=value

print(answer)