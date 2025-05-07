package graph;

import java.util.PriorityQueue;

/*
*Problem Name : Find Minimum Time to Reach Last Room I
*
*Problem Link : https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/description/?envType=daily-question&envId=2025-05-07
*
*Problem Statement : 
*
* There is a dungeon with n x m rooms arranged as a grid.

You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes exactly one second.

Return the minimum time to reach the room (n - 1, m - 1).

Two rooms are adjacent if they share a common wall, either horizontally or vertically.



Example 1:

Input: moveTime = [[0,4],[4,4]]

Output: 6

Explanation:

The minimum time required is 6 seconds.

At time t == 4, move from room (0, 0) to room (1, 0) in one second.
At time t == 5, move from room (1, 0) to room (1, 1) in one second.
Example 2:

Input: moveTime = [[0,0,0],[0,0,0]]

Output: 3

Explanation:

The minimum time required is 3 seconds.

At time t == 0, move from room (0, 0) to room (1, 0) in one second.
At time t == 1, move from room (1, 0) to room (1, 1) in one second.
At time t == 2, move from room (1, 1) to room (1, 2) in one second.
Example 3:

Input: moveTime = [[0,1],[1,2]]

Output: 3



Constraints:

2 <= n == moveTime.length <= 50
2 <= m == moveTime[i].length <= 50
0 <= moveTime[i][j] <= 10^9
*
* Approach 1 
*--------------
*TC = O(n*m log(n * m) ) SC = O(n * m )
*/
public class FindMinimumTimeToReachLastRoomI{
    private int n, m;
    private int directions[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean visited[][];

    public int minTimeToReach(int[][] moveTime) {
        n = moveTime.length;
        m = moveTime[0].length;
        visited = new boolean[n][m];
        return solve(moveTime);
    }

    private int solve(int[][] moveTime) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[2] - b[2]); // min heap
        pq.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int r = top[0], c = top[1], tr = top[2];
            if(r == n - 1 && c == m - 1) return tr;
            for(int[] dir : directions){
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(isValid(nr, nc)){
                    // System.out.println("nr = " + nr + "nc = " + nc + "time = " + (1 + Math.max(0, moveTime[nr][nc] - tr)));
                    pq.offer(new int[]{nr, nc, 1 + tr + Math.max(0, moveTime[nr][nc] - tr)});
                    visited[nr][nc] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private boolean isValid(int r, int c){
        return (r >= 0 && r < n && c >= 0 && c < m && !visited[r][c]);
    }
}