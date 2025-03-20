package dp;

/*
*Problem Name : Stock Buy and Sell – Max 2 Transactions Allowed
*
*Problem Link : https://www.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1
*
*Problem Statement : 
*
* In daily share trading, a trader buys shares and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, find out the maximum profit that a share trader could have made.

You are given an array prices[] representing stock prices throughout the day. Note that the second transaction can only start after the first one is complete (buy->sell->buy->sell).

Examples:

Input: prices[] = [10, 22, 5, 75, 65, 80]
Output: 87
Explanation:
Trader will buy at 10 and sells at 22.
Profit earned in 1st transaction = 22 - 10 = 12.
Then he buys at 5 and sell at 80.
Profit earned in 2nd transaction = 80 - 5 = 75.
Total profit earned = 12 + 75 = 87.
Input: prices[] = [2, 30, 15, 10, 8, 25, 80]
Output: 100
Explanation:
Trader will buy at 2 and sells at 30.
Profit earned in 1st transaction = 30 - 2 = 28.
Then he buys at 8 and sell at 80.
Profit earned in 2nd transaction = 80 - 8 = 72.
Total profit earned = 28 + 72 = 100.
Constraints:
1 <= prices.size() <= 10^5
1 <= prices[i] <= 10^5
* Approach 1 : Recurtion
*--------------
*TC = O(2^n) SC = O(1)
*
* Approach 2 : Recurtion + Memorization
*--------------
*TC = O(n) SC = O(n)
*
* Approach 3 : Bottom up
*--------------
*TC = O(n) SC = O(n)
*/
public class StockBuyAndSellMax2TransactionsAllowed{
    public int maxProfit(int[] prices) {
//        Integer dp[][][] = new Integer[prices.length + 1][3][2];
//        return  solve(0, 2, 0 , prices, dp);

        int[][][] dp = new int[prices.length + 1][3][2];
        for(int i = prices.length-1 ; i >= 0; i--){
            for(int j = 1 ; j<=2; j++){
                for(int buy = 0; buy <= 1 ; buy++){
                    dp[i][j][buy]  =  dp[i + 1][j][buy];
                    if(buy == 0){
                        dp[i][j][buy] = Math.max(dp[i][j][buy],
                                -1 *prices[i] +  dp[i + 1][j][1]);
                    }else{
                        dp[i][j][buy] = Math.max(
                                dp[i][j][buy],
                                prices[i] +  dp[i + 1][j-1][0]);
                    }
                }
            }
        }
        return dp[0][2][0];
    }
    private int solve(int i, int k, int buy, int[] prices, Integer dp[][][]){
        if(k == 0) return 0;
        if(i >= prices.length) return  0 ;
        if (dp[i][k][buy] != null) return dp[i][k][buy];
        int skip = solve(i + 1, k, buy, prices, dp);
        int take = 0;
        if(buy == 0){
            take = -1 * prices[i] + solve(i + 1, k, 1, prices, dp);
        }else {
            take = prices[i] + solve(i + 1, k - 1, 0, prices, dp);
        }
        return  dp[i][k][buy] = Math.max(skip, take);

    }
}