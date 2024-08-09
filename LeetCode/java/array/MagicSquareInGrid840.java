package LeetCode.java.array;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem Name : Magic Squares In Grid 840
 * Problem Link : https://leetcode.com/problems/magic-squares-in-grid/description/
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?

Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.

 

Example 1:


Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
Output: 1
Explanation: 
The following subgrid is a 3 x 3 magic square:

while this one is not:

In total, there is only one magic square inside the given grid.
Example 2:

Input: grid = [[8]]
Output: 0
 

Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 10
0 <= grid[i][j] <= 15


Time Complexity : O(m * n)
Space Complexity : O(1)
 *  
 */
public class MagicSquareInGrid840 {
    private boolean isAllInRange(int grid[][], int r, int c){
        Set<Integer> visited = new HashSet<>();
        for(int i=r; i < r+3; i++){
            for(int j=c; j< c + 3; j++){
                if(grid[i][j] > 9 || grid[i][j] <= 0) return false; 
                if(visited.contains(grid[i][j])) return false;
                visited.add(grid[i][j]);
            }
        }
        return true;
    }
    private boolean isMagicSquare(int[][] grid, int r, int c) {
        if (isAllInRange(grid, r, c)) {
            int r1 = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
            int r2 = grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2];
            int r3 = grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2];
            int c1 = grid[r][c] + grid[r + 1][c] + grid[r + 2][c];
            int c2 = grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1];
            int c3 = grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2];
            int d1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
            int d2 = grid[r + 2][c] + grid[r + 1][c + 1] + grid[r][c + 2];
            return (r1 == r2) && (r2 == r3) && (r3 == c1) && (c1 == c2) && (c2 == c3) && (c3 == d1) && (d1 == d2);
        }
        return false;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (isMagicSquare(grid, i, j))
                    cnt++;
            }
        }
        return cnt;
    }
}
