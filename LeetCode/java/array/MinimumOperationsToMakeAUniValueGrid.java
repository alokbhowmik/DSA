package array;

import java.util.Arrays;

/*
*Problem Name : Minimum Operations to Make a UniValue Grid
*
*Problem Link : https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/?envType=daily-question&envId=2025-03-26
*
*Problem Statement : 
*You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.

A uni-value grid is a grid where all the elements of it are equal.

Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.



Example 1:


Input: grid = [[2,4],[6,8]], x = 2
Output: 4
Explanation: We can make every element equal to 4 by doing the following:
- Add x to 2 once.
- Subtract x from 6 once.
- Subtract x from 8 twice.
A total of 4 operations were used.
Example 2:


Input: grid = [[1,5],[2,3]], x = 1
Output: 5
Explanation: We can make every element equal to 3.
Example 3:


Input: grid = [[1,2],[3,4]], x = 2
Output: -1
Explanation: It is impossible to make every element equal.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10^5
1 <= m * n <= 10^5
1 <= x, grid[i][j] <= 10^4
* Approach 1 
*--------------
*TC = O(m*nlog(m*n)) SC = O(n * m)
*/
public class MinimumOperationsToMakeAUniValueGrid{
    public int minOperations(int[][] grid, int x) {
        int n = grid.length * grid[0].length;
        int[] arr = new int[n];
        int i = 0;
        if(arr.length == 1) return 0 ;
        for(int[] row : grid){
            for(int num : row){
                arr[i] = num;
                i++;
            }
        }

        Arrays.sort(arr);
        int minMove = Integer.MAX_VALUE;
        minMove = Math.min(minMove,
                Math.min(possibleMove(arr, x, arr[n/2]), possibleMove(arr, x, arr[n/2 - 1])));
        return minMove == Integer.MAX_VALUE ? -1 : minMove;
    }

    private int possibleMove(int[] arr, int x, int target){
        int move = 0;
        for(int num : arr){
            int diff = Math.abs(target - num);
            if(diff % x == 0){
                move += diff / x;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        return move;
    }
}