package graph;

import java.util.*;

/*
*Problem Name : DFS of Graph
*
*Problem Link : https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
*
*Problem Statement : 
*
* Given a connected undirected graph represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Search (DFS) traversal starting from vertex 0, visiting vertices from left to right as per the given adjacency list, and return a list containing the DFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.

Examples:

Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 4, 3, 1]
Explanation: Starting from 0, the DFS traversal proceeds as follows:
Visit 0 → Output: 0
Visit 2 (the first neighbor of 0) → Output: 0, 2
Visit 4 (the first neighbor of 2) → Output: 0, 2, 4
Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3
Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1
Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the DFS traversal proceeds as follows:
Visit 0 → Output: 0
Visit 1 (the first neighbor of 0) → Output: 0, 1
Visit 2 (the first neighbor of 1) → Output: 0, 1, 2
Visit 3 (the first neighbor of 2) → Output: 0, 1, 2, 3
Backtrack to 2 and visit 4 → Final Output: 0, 1, 2, 3, 4
Constraints:
1 ≤ adj.size() ≤ 10^4
1 ≤ adj[i][j] ≤ 10^4
*
* Approach 1 
*--------------
*TC = O(n) SC = O(n)
*/
public class DFSOfGraph{
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> visited   = new HashSet<>();
        dfs(0, adj, res, visited);
        return res;
    }

    void dfs(int src, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res,  Set<Integer> visited){

        res.add(src);
        visited.add(src);
        for(int ngb : adj.get(src)){
            if(visited.contains(ngb)) continue;
            dfs(ngb, adj, res, visited);
        }
    }
}