n = 30
dp = [[[0]*2 for _ in range(3)] for _ in range(n+1)]
dp[0][0][0] = 1

for i in range(n):
    for j in range(3):
        for k in range(2):
            # Adding 'O'
            dp[i+1][0][k] += dp[i][j][k]
            # Adding 'A'
            if j < 2:
                dp[i+1][j+1][k] += dp[i][j][k]
            # Adding 'L'
            if k < 1:
                dp[i+1][0][k+1] += dp[i][j][k]

print(sum(dp[n][j][k] for j in range(3) for k in range(2)))
