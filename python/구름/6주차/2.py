n=int(input())
arr=input()
answer=""
for i in range(0,len(arr),2):
    x=(int(arr[i+1])**2%26)
    answer+=chr((ord(arr[i])+x-ord('a'))%26+ord('a'))
print(answer)