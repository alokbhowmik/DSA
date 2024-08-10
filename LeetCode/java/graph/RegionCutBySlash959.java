package LeetCode.java.graph;

/**
 * 
 * Problem Name : Region Cut By Slice 959
 * Problem Link : https://leetcode.com/problems/regions-cut-by-slashes/
 * 
*Problem Statement
 * An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. These characters divide the square into contiguous regions.

Given the grid grid represented as a string array, return the number of regions.

Note that backslash characters are escaped, so a '\' is represented as '\\'.

 

Example 1:


Input: grid = [" /","/ "]
Output: 2
Example 2:


Input: grid = [" /","  "]
Output: 1
Example 3:


Input: grid = ["/\\","\\/"]
Output: 5
Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 30
grid[i][j] is either '/', '\', or ' '.

Time Complexity : O(n^2)
Space Complexity : O(n^2)
 */
public class RegionCutBySlash959 {
    class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]);  // Path compression
            }
            return parent[p];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    rank[rootP]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(4 * n * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char c = grid[i].charAt(j);

                if (c == '/') {
                    uf.union(index + 0, index + 3);
                    uf.union(index + 1, index + 2);
                } else if (c == '\\') {
                    uf.union(index + 0, index + 1);
                    uf.union(index + 2, index + 3);
                } else {
                    uf.union(index + 0, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                }

                // Connect to adjacent cells
                if (i < n - 1) {  // Connect to the cell below
                    uf.union(index + 2, index + 4 * n + 0);
                }
                if (j < n - 1) {  // Connect to the cell to the right
                    uf.union(index + 1, index + 4 + 3);
                }
            }
        }

        return uf.getCount();
    }
}
