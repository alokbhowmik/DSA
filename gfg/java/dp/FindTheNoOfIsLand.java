package gfg.java.dp;

/**
 * 
 * Problem Name : Find the number of islands
 * Problem Link : https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
 * 
 * Problem Statement 
 * 
 * Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid = [[0,1],[1,0],[1,1],[1,0]]
Output: 1
Explanation:
The grid is-
0 1
1 0
1 1
1 0
All lands are connected.
Input: grid = [[0,1,1,1,0,0,0],[0,0,1,1,0,1,0]]
Output: 2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 2 0 
There are two islands in the grid. One island is marked by '1' and the other by '2'.
Expected Time Complexity: O(n*m)
Expected Space Complexity: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
0 ≤ grid[i][j] ≤ 1Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.


Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid = [[0,1],[1,0],[1,1],[1,0]]
Output: 1
Explanation:
The grid is-
0 1
1 0
1 1
1 0
All lands are connected.
Input: grid = [[0,1,1,1,0,0,0],[0,0,1,1,0,1,0]]
Output: 2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 2 0 
There are two islands in the grid. One island is marked by '1' and the other by '2'.
Expected Time Complexity: O(n*m)
Expected Space Complexity: O(n*m)

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] = {'0', '1'}

Time Complexity : O(n * m)
Space Complexity : O(n * m)
 */
public class FindTheNoOfIsLand {
    private final int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}, 
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };
    
    void dfs(int r, int c, char[][] grid){
        if(r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] == '0') return;
        grid[r][c] = '0';
        for(int[] dir : directions){
            dfs(r + dir[0], c + dir[1], grid);
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
