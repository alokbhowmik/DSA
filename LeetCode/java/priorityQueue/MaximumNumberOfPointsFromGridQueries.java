package priorityQueue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
*Problem Name : Maximum Number of Points From Grid Queries
*
*Problem Link : https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/description/?envType=daily-question&envId=2025-03-28
*
*Problem Statement : 
*
* You are given an m x n integer matrix grid and an array queries of size k.

Find an array answer of size k such that for each integer queries[i] you start in the top left cell of the matrix and repeat the following process:

If queries[i] is strictly greater than the value of the current cell that you are in, then you get one point if it is your first time visiting this cell, and you can move to any adjacent cell in all 4 directions: up, down, left, and right.
Otherwise, you do not get any points, and you end this process.
After the process, answer[i] is the maximum number of points you can get. Note that for each query you are allowed to visit the same cell multiple times.

Return the resulting array answer.



Example 1:


Input: grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
Output: [5,8,1]
Explanation: The diagrams above show which cells we visit to get points for each query.
Example 2:


Input: grid = [[5,2,1],[1,1,2]], queries = [3]
Output: [0]
Explanation: We can not get any points because the value of the top left cell is already greater than or equal to 3.


Constraints:

m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 10^5
k == queries.length
1 <= k <= 10^4
1 <= grid[i][j], queries[i] <= 10^6
* Approach 1 
*--------------
*TC = O(m * n * k ) SC = O(m * n )
*
* Approach 2
*--------------
*TC = O(k log(k) + m*nlog(m*n) ) SC = O(m * n + k  )
*/
public class MaximumNumberOfPointsFromGridQueries{
//    public int[] maxPoints(int[][] grid, int[] queries) {
//        int k = queries.length;
//        int[] res = new int[k];
//
//        for(int i = 0; i<k; i++){
//
//            res[i] = solve(0, 0, queries[i], grid, new HashSet<String>());
//        }
//        return res;
//    }
//
//    private int solve(int r, int c, int val, int[][] grid, Set<String> visited){
//        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return 0;
//        if(grid[r][c] >= val) return 0;
//        String cell = r + "@" + c;
//        if(visited.contains(cell)) return 0 ;
//        visited.add(cell);
//        return 1 + solve(r + 1, c, val, grid, visited)
//                + solve(r - 1, c, val, grid, visited)
//                + solve(r, c + 1, val, grid, visited)
//                + solve(r, c - 1, val, grid, visited);
//    }

//    --------------- Approach 2 ------------------

    private final int[][] directions = {
            { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
    };
    private int rows, cols;

    public int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;
        rows = grid.length;
        cols = grid[0].length;

        int[][] pairs = new int[k][2];
        Set<String> visited = new HashSet<>();
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < k; i++) {
            pairs[i] = new int[] { queries[i], i };
        }

        int[] temp = new int[k];
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int idx = 0;
        que.offer(new int[] { grid[0][0], 0, 0 });
        visited.add(getCell(0, 0));

        while (!que.isEmpty() && idx < k) {
            // System.out.println(que.peek());

            if (que.peek()[0] < pairs[idx][0]) {
                temp[idx]++;
                int[] currCell = que.poll();
                for (int[] dir : directions) {
                    int nr = currCell[1] + dir[0];
                    int nc = currCell[2] + dir[1];
                    if (isValid(nr, nc) &&
                            !visited.contains(getCell(nr, nc))) {
                        que.offer(new int[] { grid[nr][nc], nr, nc });
                        visited.add(getCell(nr, nc));
                    }
                }
            } else {
                idx++;
            }
        }
        int[] ans = new int[k];
        for (int i = 1; i < k; i++) {
            temp[i] += temp[i - 1];
        }
        for (int i = 0; i < k; i++) {
            ans[pairs[i][1]] = temp[i];
        }
        return ans;
    }

    private String getCell(int r, int c) {
        return r + "@" + c;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}