import java.util.Scanner;

/*
    A number n can be broken into three parts n/2, n/3, and n/4 (consider only the integer part).
    Each number obtained in this process can be divided further recursively.
    Find the maximum sum that can be obtained by summing up the divided parts together.
    Note: It is possible that we don't divide the number at all.

    Constraints:
    0 <= n <= 106
*/

/**
 * MaximumSum
 */
public class MaximumSum {
    public int findMaxSum(int n) {
        
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(i, dp[i / 2] + dp[i / 3] + dp[i / 4]);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        MaximumSum ms = new MaximumSum();
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            System.out.println(ms.findMaxSum(n));
        }
    }
}