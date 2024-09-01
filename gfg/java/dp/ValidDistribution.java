package gfg.java.dp;
/**
 * Problem Name : ValidDistribution 
 * Problem Link : https://practice.geeksforgeeks.org/contest/gfg-weekly-170-rated-contest/problems
 * 
 * Not able to copy the problem statement. Kindly check the above Lin

 * 
 * Time Complexity : O(n*sum(sweetness)/3) 
 * Space Complexity : O(n*sum(sweetness)/3)
 * 
 */
public class ValidDistribution {
    int solve(int[] arr, int i, int target, Integer dp[][]){
        if(target == 0) return 1;
        if(i >= arr.length || target < 0) return 0;
        if(dp[i][target] != null) return dp[i][target];
        int take = solve(arr, i + 1, target - arr[i], dp);
        int skip = solve(arr, i + 1, target, dp);
        return dp[i][target] = take | skip;
    }
    public int isValid(int n, int[] sweetness) {
        // code here
        int total = 0;
        for(int sweet: sweetness){
            total += sweet;
        }
        if(total % 3 != 0) return 0;
        Integer[][] dp = new Integer[n][total];
        return solve(sweetness, 0, total/3, dp);
    }
}
