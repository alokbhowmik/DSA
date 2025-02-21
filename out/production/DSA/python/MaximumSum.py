
    # A number n can be broken into three parts n/2, n/3, and n/4 (consider only the integer part).
    # Each number obtained in this process can be divided further recursively.
    # Find the maximum sum that can be obtained by summing up the divided parts together.
    # Note: It is possible that we don't divide the number at all.

    # Constraints:
    # 0 <= n <= 106


def findMaximumSum(n:int)->int:
    dp = [0]*(n+1)
    for i in range(1, n+1):
        dp[i] = max(i, dp[i//2] + dp[i//3] + dp[i//4])
    return dp[n]

print(findMaximumSum(int(input())))