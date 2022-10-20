arr = list(map(int,input().split()))
arr.sort()

print(abs(arr[3]-arr[0])+abs(arr[2]-arr[1]))