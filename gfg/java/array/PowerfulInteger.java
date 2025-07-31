package array;

/*
*Problem Name : Powerful Integer
*
*Problem Link : https://www.geeksforgeeks.org/problems/powerfull-integer--170647/1
*
*Problem Statement : 
*You are given a 2D integer array intervals[][] of length n, where each intervals[i] = [start, end] represents a closed interval (i.e., all integers from start to end, inclusive). You are also given an integer k. An integer is called Powerful if it appears in at least k intervals. Find the maximum Powerful Integer.

Note: If no integer occurs at least k times return -1.

Examples:

Input : n = 3, intervals[][] = [[1, 3], [4, 6], [3, 4]], k = 2
Output: 4
Explanation: Integers 3 and 4 appear in 2 intervals. The maximum is 4.
Input : n = 4, intervals[][] = [[1, 4], [12, 45], [3, 8], [10, 12]], k = 3
Output: -1
Explanation: No integer appears in at least 3 intervals.
Input : n = 5, intervals[][] = [[16, 21], [5, 8], [12, 17], [17, 29], [9, 24]], k = 3
Output: 21
Explanation: Integers 16, 17, 18, 19, 20 and 21 appear in at least 3 intervals. The maximum is 21.
Constraints:
1 ≤ n ≤ 10^5
1 ≤ intervals[i][0] ≤ intervals[i][1] ≤ 10^9
1 ≤ k ≤ 10^5
* Approach 1 
*--------------
*TC = O(n) SC = O(n)
*
*
*/
public class PowerfulInteger{
    public int powerfulInteger(int[][] intervals, int k) {
        // code here
        /*
        ans = 4
        [1, 0, 1, 0, -1, 0, -1]
        */
        int res = -1;
        int max = 0;
        for(int[] interval : intervals){
            max = Math.max(max, interval[1]) ;
        }
        int[] prefix = new int[max + 1] ;
        for(int[] interval : intervals){
            int x = interval[0] - 1;
            int y = interval[1] ;
            prefix[x] += 1;
            prefix[y] -= 1;
        }
        int prefixSum = 0;
        for(int i = 0; i<= max; i++){
            prefixSum += prefix[i] ;
            if(prefixSum >= k){
                res = i + 1 ;
            }
        }
        return res ;
    }
}