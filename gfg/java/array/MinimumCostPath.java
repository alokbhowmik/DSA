package gfg.java.array;
import java.util.*;
/**
 * 
 * 
 * Problem Name : Minimum Cost Path
 * Problem Link : https://www.geeksforgeeks.org/problems/minimum-cost-path3833/1
 * 
 * Problem Statement 
 * =====================
 * Given a square grid of size N, each cell of which contains an integer cost that represents a cost to traverse through that cell, we need to find a path from the top left cell to the bottom right cell by which the total cost incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).  

Examples :

Input: grid = {{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}}
Output: 43
Explanation: The grid is-
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10
The minimum cost is-
9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
Input: grid = {{4,4},{3,7}}
Output: 14
Explanation: The grid is-
4 4
3 7
The minimum cost is- 4 + 3 + 7 = 14.
Expected Time Complexity: O(n2*log(n))
Expected Auxiliary Space: O(n2) 
 Constraints:
1 ≤ n ≤ 500
1 ≤ cost of cells ≤ 500
 */
public class MinimumCostPath {
    class Triple implements Comparable<Triple>{
	    int x, y, val;
	    Triple(int x, int y, int val){
	        this.x = x;
	        this.y = y;
	        this.val = val;
	    }
	    public int compareTo(Triple t){
	        return this.val - t.val;
	    }
	}
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        PriorityQueue<Triple> pq = new PriorityQueue<>();
        int n = grid.length;
        int directions[][] = new int[][]{
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
        };
        // boolean visited[][] = new boolean[n][n];
        pq.offer(new Triple(0, 0, grid[0][0]));
        grid[0][0] = 0;
        while(!pq.isEmpty()){
            Triple t = pq.poll();
            int x = t.x, y = t.y, val = t.val;
            if(x == n-1 && y == n-1){
                return val;
            }
            for(int[] dir: directions){
                int new_x = x + dir[0];
                int new_y = y + dir[1];
                if(new_x >=0 && new_x < n && new_y >= 0 && new_y < n && grid[new_x][new_y] > 0){
                    pq.offer(new Triple(new_x, new_y, val + grid[new_x][new_y]));
                    grid[new_x][new_y] = 0;
                }
            }
        }
        return -1;
    }
}
