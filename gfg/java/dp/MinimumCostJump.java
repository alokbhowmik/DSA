package gfg.java.dp;

import java.util.*;

public class MinimumCostJump {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=i-k; j < i; j++){
                if(j >= 0)
                dp[i] = Math.min(dp[i], dp[j] + Math.abs(arr[i] - arr[j]));
            }
        }
        return dp[n-1];
    }
}
