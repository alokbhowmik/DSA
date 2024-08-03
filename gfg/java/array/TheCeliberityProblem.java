package gfg.java.array;

/**
 * 
 * Problem Name : The Celebrity Problem
 * Problem Link : https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
 * 
 * 
 * 
 * A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people.  A square matrix mat is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.

Note: Follow 0-based indexing.

Examples:

Input: mat[][] = [[0 1 0],
                [0 0 0], 
                [0 1 0]]
Output: 1
Explanation: 0th and 2nd person both know 1. Therefore, 1 is the celebrity. 
Input: mat[][] = [[0 1],
                [1 0]]
Output: -1
Explanation: The two people at the party both know each other. None of them is a celebrity.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(1)

Constraints:
1 <= mat.size()<= 3000
0 <= mat[i][j]<= 1

Seen this question in a real interview before ?
Yes



Time Complexity = O(n^2)
Space Complexity = O(n)

 */
public class TheCeliberityProblem {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int freq[] = new int[n];
        // for(int i=0; i<n; i++) freq[i][i] = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1 && i != j){
                    freq[j]++;
                }
            }
        }
        
        int cnt = 0;
        int idx = -1;
        for(int i=0; i<n; i++){
            // System.out.print(freq[i] + " ");
            if(freq[i] == n - 1){
                cnt++;
                idx = i;
            }
            if(cnt > 1) return -1;
        }
        if(idx != -1){
            
            for(int i=0; i<n; i++){
                if(mat[idx][i] != 0 && idx != i){
                    return -1;
                }
            }
        }
        return idx;
    }
}
