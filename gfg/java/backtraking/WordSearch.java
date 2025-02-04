package backtraking;
/*
*
* Problem Name : Word Search
* Problem Link : https://www.geeksforgeeks.org/problems/word-search/1
*
* Problem Statement :
*
* You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.

Examples :

Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: true
Explanation:

The letter cells which are used to construct the "GEEK" are colored.
Input: mat[][] = [['T', 'E', 'U'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: false
Explanation:

It is impossible to construct the string word from the mat using each cell only once.
Input: mat[][] = [['A', 'B', 'A'], ['B', 'A', 'B']], word = "AB"
Output: true
Explanation:

There are multiple ways to construct the word "AB".
Constraints:
1 ≤ n, m ≤ 6
1 ≤ L ≤ 15
mat and word consists of only lowercase and uppercase English letters.
*
 * */
public class WordSearch {
    // TC = O(m * n * l) Sc = O(1)
    private int n, m;
    private int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    public boolean isWordExist(char[][] mat, String word) {
        // Code here
        n = mat.length ;
        m = mat[0].length ;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(mat[r][c] == word.charAt(0)){
                    if(search(mat, word, r, c, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] mat, String word, int r, int c, int idx){
        if(idx >= word.length()) return true;
        if(r < 0 || r >= n || c < 0 || c >= m) return false;
        if(mat[r][c] != word.charAt(idx)) return false;
        char ch = mat[r][c];
        mat[r][c] = '.';
        boolean ans = false;
        for(int[] dir : directions){
            ans |= search(mat, word, r + dir[0], c + dir[1], idx + 1);
        }
        mat[r][c] = ch; // backtracking undoing the process
        return ans;
    }
}
