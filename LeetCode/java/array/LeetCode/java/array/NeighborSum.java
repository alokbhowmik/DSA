package LeetCode.java.array;

/**
 * 
 * 
 * Problem Name : Design Neighbor Sum Service
 * Problem Link : https://leetcode.com/contest/weekly-contest-409/problems/design-neighbor-sum-service/description/
 * 
 * Problem Statement
 * ------------------
 * 
 * You are given a n x n 2D array grid containing distinct elements in the range [0, n2 - 1].

Implement the neighborSum class:

neighborSum(int [][]grid) initializes the object.
int adjacentSum(int value) returns the sum of elements which are adjacent neighbors of value, that is either to the top, left, right, or bottom of value in grid.
int diagonalSum(int value) returns the sum of elements which are diagonal neighbors of value, that is either to the top-left, top-right, bottom-left, or bottom-right of value in grid.


 

Example 1:

Input:

["neighborSum", "adjacentSum", "adjacentSum", "diagonalSum", "diagonalSum"]

[[[[0, 1, 2], [3, 4, 5], [6, 7, 8]]], [1], [4], [4], [8]]

Output: [null, 6, 16, 16, 4]

Explanation:



The adjacent neighbors of 1 are 0, 2, and 4.
The adjacent neighbors of 4 are 1, 3, 5, and 7.
The diagonal neighbors of 4 are 0, 2, 6, and 8.
The diagonal neighbor of 8 is 4.
Example 2:

Input:

["neighborSum", "adjacentSum", "diagonalSum"]

[[[[1, 2, 0, 3], [4, 7, 15, 6], [8, 9, 10, 11], [12, 13, 14, 5]]], [15], [9]]

Output: [null, 23, 45]

Explanation:



The adjacent neighbors of 15 are 0, 10, 7, and 6.
The diagonal neighbors of 9 are 4, 12, 14, and 15.
 

Constraints:

3 <= n == grid.length == grid[0].length <= 10
0 <= grid[i][j] <= n2 - 1
All grid[i][j] are distinct.
value in adjacentSum and diagonalSum will be in the range [0, n2 - 1].
At most 2 * n2 calls will be made to adjacentSum and diagonalSum.

    Time Complexity = O(n^2);
    Space Complexity = O(1)
 */
public class NeighborSum {
    int[][] grid;
    public NeighborSum(int[][] grid) {
        this.grid = grid;
    }
    
    public int adjacentSum(int value) {
        int n = grid.length;
        int m = grid[0].length;
        int i = -1, j = -1;
        boolean found = false;
        for(i=0; i<n; i++){
            for(j=0; j<m; j++){
                if(grid[i][j] == value){
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        int sum = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int k=0; k<4; k++){
            int x = i + dx[k], y = j + dy[k];
            if(x >=0 && x < n && y >= 0 && y < m){
                sum += grid[x][y];
            }
        }
        return sum;
    }
    
    public int diagonalSum(int value) {
        int i = -1, j = -1;
        int n = grid.length;
        int m = grid[0].length;
        boolean found = false;

        for(i=0; i<n; i++){
            for(j =0; j<n; j++){
                if(value == grid[i][j]){
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        int sum = 0;
        int x, y;
        x = i + 1;
        y = j + 1;
        if(x < n && y < m){
            sum += grid[x][y];
        }
        x = i - 1;
        y = j - 1;
        if(x >= 0 && y >= 0){
            sum += grid[x][y];
        }
        x = i - 1;
        y = j + 1;
        if(x >= 0 && y < m){
            sum += grid[x][y];
        }
        x = i + 1;
        y = j -1;
        if(n > x && y >= 0){
            sum += grid[x][y];
        }
        return sum;
    }
}
