package DSU;

import java.util.HashSet;
import java.util.Set;

/*
*  Problem Name : Making A Large Island
*  Problem Link : https://leetcode.com/problems/making-a-large-island/description/
*
*  Problem Statement
*   You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.



Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: grid = [[1,1],[1,0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: grid = [[1,1],[1,1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.


Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 500
grid[i][j] is either 0 or 1.
*
* */
public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        // 1 0 0 1
        // 0 1 2 3
        // i * n + j

        // 1 1 1 0
        // 0 1 2 3
        int[][] directions = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int currNode = r * n + c;
                    // System.out.println("Curr Row = " + r + "Curr Col " + c);
                    for (int[] dir : directions) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int neighbourNode = nr * n + nc;
                            uf.union(currNode, neighbourNode);
                        }
                    }
                }
            }
        }
        Set<Integer> seen = new HashSet<>();

        boolean hasZero = false;
        int ans = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    hasZero = true;
                    int currIslandSize = 1;
                    for (int[] dir : directions) {
                        int nr = row + dir[0], nc = col + dir[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int root = uf.find(nr * n + nc);
                            if (seen.contains(root)) continue;
                            currIslandSize += uf.getSize(root);
                            seen.add(root);
                        }
                    }
                    seen.clear();
                    ans = Math.max(ans, currIslandSize);

                }
            }
        }

        return hasZero ? ans : n * n;

    }

    class UnionFind {
        private final int[] parent;
        private final int[] deg;

        UnionFind(int n) {
            parent = new int[n + 1];
            deg = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                deg[i] = 1;
            }
        }

        void union(int a, int b) {
            int parent_A = find(a);
            int parent_B = find(b);
            if (parent_A == parent_B)
                return;

            if (deg[parent_A] < deg[parent_B]) {
                parent[parent_A] = parent_B;
                deg[parent_B] += deg[parent_A];
            } else {
                parent[parent_B] = parent_A;
                deg[parent_A] += deg[parent_B];
            }
        }

        int find(int root) {
            if (parent[root] == root)
                return root;
            return parent[root] = find(parent[root]);
        }

        public int getSize(int root) {
            return deg[root];
        }
    }
}
