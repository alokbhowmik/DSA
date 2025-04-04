package DSU;

/*
*Problem Name : Undirected Graph Cycle
*
*Problem Link : https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
*
*Problem Statement : 
*
* Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.

Examples:

Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: true
Explanation:

1 -> 2 -> 0 -> 1 is a cycle.
Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
Output: false
Explanation:

No cycle in the graph.
Constraints:
1 ≤ V ≤ 10^5
1 ≤ E = edges.size() ≤ 10^5
*
* Approach 1 
*--------------
*TC = O(V + E) SC = O(V)
*/
public class UndirectedGraphCycle{
    private class DSU{
        private int[] parent, size;
        DSU(int n){
            parent = new int[n];
            size   = new int[n];

            for(int i = 0; i<n; i++){
                parent[i] = i;
                size[i]   = 1;
            }
        }

        public int find(int node){
            if(node == parent[node]) return node;
            return parent[node] = find(parent[node]);
        }

        public boolean union(int u, int v){
            int parentU = find(u);
            int parentV = find(v);
            if(parentU == parentV) return true;
            if(size[parentU] >= size[parentV]){
                size[parentU] += size[parentV];
                parent[parentV] = parent[parentU];
            }else{
                size[parentV] += size[parentU];
                parent[parentU] = parent[parentV];
            }
            return false;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        DSU dsu = new DSU(V);
        for(int[] edge : edges){ // no of edges
            int u = edge[0], v = edge[1];
            if(dsu.union(u, v)) return true;
        }
        return false;

    }
}