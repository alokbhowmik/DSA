package array;
/*
*
* Problem Name : Maximum Number of Fish in a Grid
*
* Problem Link : https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/
*
* Problem Statement
*
* You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:

A land cell if grid[r][c] = 0, or
A water cell containing grid[r][c] fish, if grid[r][c] > 0.
A fisher can start at any water cell (r, c) and can do the following operations any number of times:

Catch all the fish at cell (r, c), or
Move to any adjacent water cell.
Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.

An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.



Example 1:


Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
Output: 7
Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
Output: 1
Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
0 <= grid[i][j] <= 10
* */
public class MaximumNumberOfFishInAGrid {
    private int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private int n, m;

    private int dfs(int r, int c, int[][] grid) {
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0)
            return 0;
        // System.out.println(r + " : " + c);
        int sum = grid[r][c];
        grid[r][c] = 0;
        for (int dir[] : directions) {
            int nr = dir[0] + r, nc = c + dir[1];
            sum += dfs(nr, nc, grid);
        }
        return sum;
    }
    public int findMaxFish(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] > 0) {
                    max = Math.max(max, dfs(r, c, grid));
                }
            }
        }
        return max;
    }
}
