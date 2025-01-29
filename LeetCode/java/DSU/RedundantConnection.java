package DSU;

/*
*
* Problem Name : Redundant Connection
* Problem Link : https://leetcode.com/problems/redundant-connection/description/
*
* Problem Statement
*
* In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.



Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]


Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.
* */

public class RedundantConnection {
    class UnionFind { // TC = O(n alpha(n)) SC = O(n)
        private final int[] parent;
        private final int[] rank;
        public int[] ans = new int[]{-1, -1};

        UnionFind(int n) {
            parent = new int[n + 1];
            rank   = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        void union(int u, int v) {
            int parent_u = find(u);
            int parent_v = find(v);

            if (parent_u != parent_v) {
                if (rank[parent_u] > rank[parent_v]) {
                    parent[parent_v] = parent_u;
                } else if (rank[parent_u] < rank[parent_v]) {
                    parent[parent_u] = parent_v;
                } else {
                    parent[parent_v] = parent_u;
                    rank[parent_u]++;
                }
            }else{
                ans[0] = u;
                ans[1] = v;
            }
        }

        private int find(int node) {
            if (node == parent[node])
                return node;
            return parent[node] = find(parent[node]);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            uf.union(u, v);
        }
        return uf.ans;
    }
}
