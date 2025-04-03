package graph;

import java.util.LinkedList;
import java.util.Queue;

/*
*Problem Name : Rotten Oranges
*
*Problem Link : https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
*
*Problem Statement : 
*
* Given a matrix mat[][] of dimension n * m where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cell have fresh oranges
2 : Cell have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j), (i, j-1), (i, j+1) (up, down, left and right) in a unit time.

Note: Your task is to return the minimum time to rot all the fresh oranges. If not possible returns -1.

Examples:

Input: mat[][] = [[0, 1, 2], [0, 1, 2], [2, 1, 1]]
Output: 1
Explanation: Oranges at positions (0,2), (1,2), (2,0) will rot oranges at (0,1), (1,1), (2,2) and (2,1) in unit time.
Input: mat[][] = [[2, 2, 0, 1]]
Output: -1
Explanation: Oranges at (0,0) and (0,1) can't rot orange at (0,3).
Input: mat[][] = [[2, 2, 2], [0, 2, 0]]
Output: 0
Explanation: There is no fresh orange.
Constraints:
1 ≤ mat.size() ≤ 500
1 ≤ mat[0].size() ≤ 500
mat[i][j] = {0, 1, 2}
*
* Approach 1  :BFS
*--------------
*TC = O(n * m ) SC = O(n * m)
*/
public class RottenOranges{
    private int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private int n, m;

    private boolean isValid(int r, int c, int[][] mat){
        return r >= 0 && r < n && c >= 0 && c < m && mat[r][c] == 1;
    }
    public int orangesRotting(int[][] mat) {
        // Code here
        n = mat.length ;
        m = mat[0].length ;
        Queue<int[]> que = new LinkedList<>();
        int freashOrange = 0;
        for(int r = 0; r < n; r++){
            for(int c=0; c<m; c++){
                if(mat[r][c] == 2){ // rotten orange
                    que.add(new int[]{r, c});
                }else if(mat[r][c] == 1){
                    freashOrange++;
                }
            }
        }
        int time = 0;
        while(!que.isEmpty()){
            int size = que.size();
            boolean find = false;
            while(size-- > 0){
                int[] top = que.remove();
                int cr = top[0], cc = top[1];
                for(int dir[] : directions){
                    if(isValid(cr + dir[0], cc + dir[1], mat)){
                        find = true;
                        que.add(new int[]{cr + dir[0], cc + dir[1]});
                        mat[cr + dir[0]][cc + dir[1]] = 2;
                        freashOrange--;
                    }
                }
            }
            if(find) time++;
        }
        return freashOrange > 0 ? -1 : time;
    }
}