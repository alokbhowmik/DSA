package graph;

import java.util.*;

/*
*Problem Name : Find the number of islands
*
*Problem Link : https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
*
*Problem Statement : 
*
* Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], ['W', 'L', 'W', 'W', 'L'], ['L', 'W', 'W', 'L', 'L'], ['W', 'W', 'W', 'W', 'W'], ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation:
The image below shows all the 4 islands in the grid.

Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
Output: 2
Expanation:
The image below shows 2 islands in the grid.

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] = {'L', 'W'}
*
* Approach 1 
*--------------
*TC = O(n * m ) SC = O(n * m)
*/
public class FindTheNumberOfIslands{
    private char[][] grid;
    private int n, m;
    private int[][] directions = {
            {0, 1}, {0,-1},{1,0}, {-1,0}, {1,1}, {-1, 1}, {-1,-1}, {1, -1}
    };

    private boolean isValid(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 'L';
    }

    private void markedConnectedLand(int r, int c){
        // DFS
//        if(isValid(r, c)){
//            grid[r][c] = '.';
//
//            for(int[] dir : directions){
//                int nr = dir[0] + r;
//                int nc = dir[1] + c;
//                markedConnectedLand(nr, nc);
//            }
//        }

        // BFS

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r, c});
        grid[r][c] = '.';

        while(!que.isEmpty()){
            int[] curr = que.poll();
            for(int[] dir : directions){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];

                if(isValid(nr, nc)){
                    que.add(new int[]{nr, nc});
                    grid[nr][nc] = '.';
                }
            }
        }
    }

    public int countIslands(char[][] grid) {
        // Code here
        this.grid = grid;
        this.n    = grid.length;
        this.m    = grid[0].length;
        int totalLand = 0;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(this.grid[r][c] == 'L'){
                    totalLand++;
                    markedConnectedLand(r, c);
                }
            }
        }
        return totalLand;
    }
}