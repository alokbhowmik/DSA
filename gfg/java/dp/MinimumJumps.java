package dp;

import java.util.Arrays;

/*
*Problem Name : Minimum Jumps
*
*Problem Link : https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
*
*Problem Statement : 
*
* You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.

For example:

If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
If arr[i] = 0, you cannot jump forward from that position.
Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.

Note:  Return -1 if you can't reach the end of the array.

Examples :

Input: arr[] = [1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9]
Output: 3
Explanation: First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last.
Input: arr = [1, 4, 3, 2, 6, 7]
Output: 2
Explanation: First we jump from the 1st to 2nd element and then jump to the last element.
Input: arr = [0, 10, 20]
Output: -1
Explanation: We cannot go anywhere from the 1st element.
Constraints:
2 ≤ arr.size() ≤ 10^4
0 ≤ arr[i] ≤ 10^4
* Approach 1 
*--------------
*TC = O(n) SC = O(n)
*/
public class MinimumJumps{
    static int minJumps(int[] arr) {
        // code here
        int n = arr.length ;
        int[] dp = new int[n];
        Arrays.fill(dp, 100000);
        dp[n - 1] = 0;
        for(int i = n - 2; i>= 0; i--){
            int min = 100000;
            for(int j = i + 1; j <= Math.min(n - 1, i + arr[i]); j++){
                min = Math.min(dp[j], min);
            }
            dp[i] = 1 + min;
        }
        return dp[0] >= 100000 ? -1 : dp[0] ;
    }
}