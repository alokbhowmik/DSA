/*
*Problem Name : Stock Buy and Sell Max K Transactions Allowed
*
*Problem Link : https://www.geeksforgeeks.org/problems/maximum-profit4657/1
*
*Problem Statement : 
*
* In the stock market, a person buys a stock and sells it on some future date. You are given an array prices[] representing stock prices on different days and a positive integer k, find out the maximum profit a person can make in at-most k transactions.

A transaction consists of buying and subsequently selling a stock and new transaction can start only when the previous transaction has been completed.

Examples :

Input: prices[] = [10, 22, 5, 80], k = 2
Output: 87
Explaination:
1st transaction: Buy at 10 and sell at 22.
2nd transaction : Buy at 5 and sell at 80.
Total Profit will be 12 + 75 = 87.
Input: prices[] = [20, 580, 420, 900], k = 3
Output: 1040
Explaination:
1st transaction: Buy at 20 and sell at 580.
2nd transaction : Buy at 420 and sell at 900.
Total Profit will be 560 + 480 = 1040.
Input: prices[] = [100, 90, 80, 50, 25],  k = 1
Output: 0
Explaination: Selling price is decreasing continuously
leading to loss. So seller cannot have any profit.
Constraints:
1 ≤ prices.size() ≤ 10^3
1 ≤ k ≤ 200
1 ≤ prices[i] ≤ 10^3
* Approach 1  : Recurtion
*--------------
*TC = O(2^(2 * n * k) ) SC = O(1)
*
* Approach 2  : Recurtion + Memorization
*--------------
*TC = O(2 * n * k) SC = O(2 * n * k)
*/
public class StockBuyAndSellMaxKTransactionsAllowed{
    int maxProfit(int prices[], int k) {
        Integer[][][] dp = new  Integer[prices.length + 1][k + 1][2];
        return solve(0, k, 0, prices, dp);
    }

    private int solve(int i,int k, int buy, int[] prices, Integer[][][] dp){
        if(k == 0) return 0 ;
        if(i >= prices.length ) return 0;
        if (dp[i][k][buy] != null) return  dp[i][k][buy];
        int skip = solve(i + 1, k, buy , prices, dp);
        int take = 0;
        if (buy == 0){
            take = -1 * prices[i] + solve(i + 1, k, 1, prices, dp);
        }else{
            take = prices[i] + solve(i + 1, k - 1, 0, prices, dp);
        }
        return dp[i][k][buy] = Math.max(take, skip);
    }
}