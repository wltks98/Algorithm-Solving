import sys
from collections import defaultdict

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 8)

n, m, k = map(int, input().split())
dp = defaultdict()

def solve(cur, limit):
    key = str([cur, limit])

    if key in dp:
        return dp[key]
    if cur == 0 or cur == n + m:
        return 1
    if limit == 0:
        return 0
    
    cnt = 0
    cnt += solve(cur + 1, limit - 1)
    cnt += solve(cur, limit - 1)
    cnt += solve(cur - 1, limit - 1)

    cnt %= 100000007
    dp[key] = cnt
    return cnt

print(solve(n, k))