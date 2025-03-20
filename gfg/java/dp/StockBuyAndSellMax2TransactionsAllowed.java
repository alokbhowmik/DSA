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
*/
public class StockBuyAndSellMax2TransactionsAllowed{
    public int maxProfit(int[] prices) {

        return  solve(0, 2, 0 , prices);
    }
    private int solve(int i, int k, int buy, int[] prices){
        if(k == 0) return 0;
        if(i >= prices.length) return  0 ;
        int skip = solve(i + 1, k, buy, prices);
        int take = 0;
        if(buy == 0){
            take = -1 * prices[i] + solve(i + 1, k, 1, prices);
        }else {
            take = prices[i] + solve(i + 1, k - 1, 0, prices);
        }
        return  Math.max(skip, take);

    }
}