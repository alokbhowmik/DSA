package gfg.java.dp;

/**
 * 
 * 
 * Problem Name : Maximize The Cut Segments
 * Problem Link : https://www.geeksforgeeks.org/problems/cutted-segments1642/1
 * Problem Statement 
 * 
 * Given an integer n denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum.

Note: if no segment can be cut then return 0.

Examples:

Input: n = 4, x = 2, y = 1, z = 1
Output: 4
Explanation: Total length is 4, and the cut
lengths are 2, 1 and 1.  We can make
maximum 4 segments each of length 1.
Input: n = 5, x = 5, y = 3, z = 2
Output: 2
Explanation: Here total length is 5, and
the cut lengths are 5, 3 and 2. We can
make two segments of lengths 3 and 2.
Expected Time Complexity : O(n)
Expected Auxiliary Space: O(n)

Constraints
1 <= n, x, y, z <= 104

Time Complexity : O(n)
Space Complexity : O(n)
 */
public class MaximizeTheCutSegment {
    int solve(int n, int x, int y, int z, Integer dp[]){
        if(n < 0) return Integer.MIN_VALUE;
        if(n == 0) return 0;
        if(dp[n] != null) return dp[n];
        int dx = solve(n-x, x, y, z, dp);
        int dy = solve(n-y, x, y, z, dp);
        int dz = solve(n-z, x, y, z, dp);
        return dp[n] = Math.max(dx, Math.max(dy, dz)) + 1;
    }
    public int maximizeCuts(int n, int x, int y, int z)
    {
        Integer dp[] = new Integer[n+1];
        solve(n, x, y, z, dp);
        return dp[n] == null || dp[n] < 0 ? 0: dp[n];
       //Your code here :           Solution 2
        // int dp[] = new int [n + 1];
        // Arrays.fill(dp, -1);
        // dp[0] = 0;
        // for(int i=0; i<=n;i++){
        //     if(i - x >= 0 && dp[i-x] != -1){
        //         dp[i] = Math.max(dp[i], dp[i-x] +1);
        //     }
        //     if(i - y >= 0 && dp[i-y] != -1){
        //         dp[i] = Math.max(dp[i], dp[i-y] +1);
        //     }
        //     if(i - z >= 0 && dp[i-z] != -1){
        //         dp[i] = Math.max(dp[i], dp[i-z] + 1);
        //     }
        // }
        // // for(int i=0; i<=n; i++){
        // //     System.out.print(dp[i] + " ");
        // // }
        // return dp[n] == -1? 0 : dp[n];
    }
}
