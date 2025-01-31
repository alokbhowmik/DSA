package backtraking;

/*
*
* Problem Name : Solve the Sudoku
*
* Problem Link : https://www.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1
*
* Problem Statement
*
* Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.

Examples:

Input: mat[][] =

Output:

Explanation: Each row, column and 3 x 3 box of the output matrix contains unique numbers.
Input: mat[][] =

Output:

Explanation: Each row, column and 3 x 3 box of the output matrix contains unique numbers.
Constraints:
mat.size() = 9
mat[i].size() = 9
0 ≤ mat[i][j] ≤ 9
* */
public class SolveTheSudoku {
    static void solveSudoku(int[][] mat) {
        // code here
        solve(mat);
    }
    private static boolean isvalid(int num, int row, int col, int[][] mat){
        // Check row
        for(int i = 0; i<mat.length; i++){
            if(mat[row][i] == num) return false;
        }

        for(int i = 0; i<mat.length; ++i){
            if(mat[i][col] == num) return false;
        }
        int rs = row - row % 3;
        int cs = col - col % 3;
        for(int r = rs; r<rs + 3; ++r){
            for(int c = cs; c < cs + 3; ++c){
                if(mat[r][c] == num) return false;
            }
        }
        return true;
    }
    private static boolean solve(int[][] mat){
        int n = mat.length ;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                // Find The empty cell
                if(mat[row][col] == 0){
                    // Try numbers for 1 - 9
                    for(int num = 1; num <= 9; num++){
                        // Check if the number is valid
                        if(isvalid(num, row, col, mat)){
                            mat[row][col] = num;

                            if(solve(mat)){
                                return true;
                            }else{
                                mat[row][col] = 0; // backtrack
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
