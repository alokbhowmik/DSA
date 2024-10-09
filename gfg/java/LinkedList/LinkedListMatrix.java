package gfg.java.LinkedList;

/**
 *  Problem Name : Linked List Matrix
 *  Problem Link : https://www.geeksforgeeks.org/problems/linked-list-matrix/1 
 *  Problem Statement 
 *  Given a Matrix mat of n*n size. Your task is constructing a 2D linked list representation of the given matrix.

Input: mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: 

Input: mat = [[23, 28], [23, 28]]
Output:

Expected Time Complexity: O(n^2)
Expected Space Complexity: O(n^2)

Constraints:
1 <= mat.size() <=15
1 <= mat[i][j] <=10^4
 * 
 * Solution 1, 2 : Time Complexity : O(n^2)
 * Space Complexity 
 * Sol1 : O(n^2)
 * Sol2 : O(N^2) it is Auxilary stack space 
 */
public class LinkedListMatrix {

    class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    private int n, m;
    private int arr[][];

    Node dfs(int r, int c) {
        // Solution 2
        if (r >= n || c >= m)
            return null;

        Node node = new Node(arr[r][c]);
        node.right = dfs(r, c + 1);
        node.down = dfs(r + 1, c);
        return node;
    }

    Node construct(int arr[][]) {
        // Add your code here.
        n = arr.length;
        m = arr[0].length;
        this.arr = arr;
        return dfs(0, 0);


        // Solution 1
        //--------------------------
        // Node[][] dp = new Node[n + 1][m + 1];
        // for(int i=0; i<n;i++){
        // for(int j=0; j<m; j++){
        // dp[i][j] = new Node(arr[i][j]);
        // }
        // }

        // for(int i=0; i<n; i++){
        // for(int j=0; j<m; j++){
        // dp[i][j].right = dp[i][j+1];
        // dp[i][j].down = dp[i+1][j];
        // }
        // }
        // return dp[0][0];
    }
}
