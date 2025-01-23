package array;

import java.util.LinkedList;
import java.util.Queue;
/*
*
*
* Problem Name : Count Servers that Communicate
*
* Problem Link : https://leetcode.com/problems/count-servers-that-communicate/description/
*
* Problem Statement
*
*
* You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with any other server.



Example 1:



Input: grid = [[1,0],[0,1]]
Output: 0
Explanation: No servers can communicate with others.
Example 2:



Input: grid = [[1,0],[1,1]]
Output: 3
Explanation: All three servers can communicate with at least one other server.
Example 3:



Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
Output: 4
Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.


Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 250
1 <= n <= 250
grid[i][j] == 0 or 1
* */
public class CountServersThatCommunicate {

    private int solve(int[][] grid, int r, int c, int m, int n){
        int count = 0;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c});
        grid[r][c] = -1;
        while(!que.isEmpty()){
            int[] top = que.poll();
            count++;
            int cr = top[0], cc = top[1];
            for(int i = 0; i<n; i++){
                if(grid[i][cc] == 1){
                    grid[i][cc] = -1;
                    que.offer(new int[]{i, cc});
                }
            }

            for(int i = 0; i<m; i++){
                if(grid[cr][i] == 1){
                    grid[cr][i] = -1;
                    que.offer(new int[]{cr, i});
                }
            }
        }
        return count == 1 ? 0 : count;
    }
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length;
//        int ans = 0;
//        for(int r = 0; r < n; r++){
//            for(int c = 0; c<m; c++){
//                if(grid[r][c] == 1){
//                    ans += solve(grid, r, c, m, n);
//                }
//            }
//        }
//        return ans;
        int[] rows = new int[n];
        int[] cols = new int[m];
        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if(grid[r][c] == 1){
                    rows[r]++;
                    cols[c]++;
                }
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1 && (rows[r] > 1 || cols[c] > 1)) {
                    count++;
                }
            }
        }
        return count;

    }
}
