package gfg.java.backtraking;

import java.util.ArrayList;

/**
 * 
 * Problem Name : NQueen 
 * Problem Link : https://www.geeksforgeeks.org/problems/n-queen-problem0315/1
 * Problem Statement 
 * 
 * 
 * The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens placement, where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. For eg below figure represents a chessboard [3 1 4 2].



Examples:

Input: 1
Output: [1]
Explaination: Only one queen can be placed in the single cell available.
Input: 4
Output: [[2 4 1 3 ],[3 1 4 2 ]]
Explaination: These are the 2 possible solutions.
Expected Time Complexity: O(n!)
Expected Auxiliary Space: O(n2) 

Constraints:
1 ≤ n ≤ 10
 */
public class NQueen {
    private void solve(int col, int[] board, int n, ArrayList<ArrayList<Integer>> res){
        if(col == n){
            res.add(convert(board));
            return;
        }
        for(int row = 0; row < n; row++){
            if(isSafe(row, col, board)){
                board[col] = row;
                solve(col+1, board, n, res);
            }
        }
    }
    
    private ArrayList<Integer> convert(int[] board){
        ArrayList<Integer> lst = new ArrayList<>();
        for(int num: board){
            lst.add(num + 1);
        }
        return lst;
    }
    
    private boolean isSafe(int row, int col, int[] board){
        
        for(int c = 0; c<col; c++){
            if(board[c] == row || Math.abs(row - board[c]) == Math.abs(col - c)){
                return false;
            }
        }    
        return true;
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[] board = new int[n];
        solve(0, board, n, res);
        return res;
    }
}
