string_1 = list(input())
string_2 = list(input())

dp = [[""] * (len(string_2) + 1) for _ in range(len(string_1) + 1)]

for i in range(1, len(string_1) + 1):
    for j in range(1, len(string_2) + 1):
        if string_1[i - 1] == string_2[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + string_1[i - 1]
        else:
            if len(dp[i - 1][j]) >= len(dp[i][j - 1]):
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = dp[i][j - 1]

        print(dp)

if len(dp[-1][-1]) == 0:
    print(0)
else:
    print(len(dp[-1][-1]))
    print(dp[-1][-1])