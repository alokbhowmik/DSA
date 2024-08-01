package gfg.java.array;

/*
 * 
 * Problem Name : Spirally traversing a matrix
 * Problem Link : https://www.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 * 
 * 
 * You are given a rectangular matrix, and your task is to return an array while traversing the matrix in spiral form.

Examples:

Input: matrix[][] = [[1, 2, 3, 4],
                  [5, 6, 7, 8],
                  [9, 10, 11, 12],
                  [13, 14, 15,16]]
Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
Explanation:

Input: matrix[][] = [[1, 2, 3, 4],
                  [5, 6, 7, 8],
                  [9, 10, 11, 12]]
Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
Explanation: Applying same technique as shown above, output for the 2nd testcase will be 1 2 3 4 8 12 11 10 9 5 6 7.
Expected Time Complexity: O(n2)
Expected Auxiliary Space: O(n2)

Constraints:
1 <= matrix.size(), matrix[0].size() <= 100
0 <= matrix[i][j]<= 100
 * 
 * 
 * 
 * 
 * Time Complexity = O(n^2)
 * Space Complexity = O(1) excluding list size;
 */
import java.util.ArrayList;

public class SpiralMatrix {
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;
        
        
        ArrayList<Integer> list = new ArrayList<>();
        int top = 0, bottom = n -1, left = 0, right = m -1;
        while(top <= bottom && left <= right){
            for(int i= left ; i<= right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            for(int i=right; top <= bottom && i >= left; i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i=bottom; left <= right && i >= top; i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
