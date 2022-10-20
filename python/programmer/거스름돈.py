n=5
money=[1,2,5]

dp = [0] * (n + 1)
dp[0] = 1
for coin in money:
    for price in range(coin, n + 1):
        dp[price] += dp[price - coin]
answer = dp[n] % 10000000007


