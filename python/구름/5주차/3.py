from itertools import permutations

n=int(input())
arr=list(map(int,input().split()))
arr.sort()


ans = 1e18
for order in permutations(arr, n):
    cur = order[0]
    for i in range(1, n):
        if cur % 10 == order[i] // 10:
            cur = cur * 10 + order[i] % 10
        else:
            cur = cur * 100 + order[i]
    ans = min(ans, cur)

print(ans)


