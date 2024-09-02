package LeetCode.java.array;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Problem Name : Count Sub Islands 1905
 * Problem Link : https://leetcode.com/problems/count-sub-islands/description/?envType=daily-question&envId=2024-08-28
 * Problem Statement
 * 
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.

 

Example 1:


Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
Output: 3
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
Example 2:


Input: grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
Output: 2 
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.
 

Constraints:

m == grid1.length == grid2.length
n == grid1[i].length == grid2[i].length
1 <= m, n <= 500
grid1[i][j] and grid2[i][j] are either 0 or 1.

 *
 * Solution 1  => DFS  
 * ===============
 * 
 * Time Complexity = O(m * n)
 * Space Complexity = O(m * n) 
 *  
 * Solution 2 => BFS 
 * 
 * Time Complexity = O(m *n)
 * Space Complexity = O(m * n)
 */
public class CountSubIsLands {
    private int m, n;
    private int[][] directions = new int[][]{
         {1, 0}, {-1, 0}, {0,1},{0, -1}
    };

    // private boolean dfs(int i, int j, int[][] grid1, int[][] grid2) {
    //     if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] != 1)
    //         return true;
    //     if (grid2[i][j] == 1 && grid1[i][j] == 0)
    //         return false;
    //     grid2[i][j] = -1;
    //     boolean ans = true;
    //     for (int[] dir : directions) {
    //         ans &= dfs(dir[0] + i, dir[1] + j, grid1, grid2);
    //     }
    //     return ans;
    // }
    
    private boolean bfs(int r, int c, int[][] grid1, int[][] grid2){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        boolean ans = grid2[r][c] == grid1[r][c];
        grid2[r][c] = 0;
        while(!queue.isEmpty()){
            int[] pos = queue.remove();
            int x = pos[0], y = pos[1];
            //if() continue; 
            for(int[] dir: directions){
                int new_x = x + dir[0], new_y = y + dir[1];
                // System.out.println(new_x + ": " + new_y);
                if(new_x < 0 || new_x >= m || new_y < 0 || new_y >= n  || grid2[new_x][new_y] == 0){
                    continue;
                }
                if(grid2[new_x][new_y] == 1 && grid1[new_x][new_y] == 0){
                    ans = false;
                }
                queue.add(new int[]{new_x, new_y});
                grid2[new_x][new_y] = 0;
            }
        }
        return ans;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt = 0;
        this.m = grid1.length;
        this.n = grid1[0].length;
        for(int i=0; i<m; i++){
            for(int j= 0; j<n; j++){
                if(grid2[i][j] == 1){
                    if(bfs(i, j, grid1, grid2)){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
