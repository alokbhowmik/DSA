package graph;

import java.util.*;

/*
*Problem Name : Directed Graph Cycle
*
*Problem Link : https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
*
*Problem Statement : 
*
* Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 3], [3, 3]]



Output: true
Explanation: 3 -> 3 is a cycle
Input: V = 3, edges[][] = [[0, 1], [1, 2]]



Output: false
Explanation: no cycle in the graph
Constraints:
1 ≤ V, E ≤ 10^5
* Approach 1 
*--------------
*TC = O(V + E) SC = O(V)
*/
public class DirectedGraphCycle{

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();


        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[V];
        boolean[] path    = new boolean[V];

        for(int[] edge : edges ){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        }

        for(int src = 0; src < V; src++){

            if(!visited[src] && dfs(src, adj, path, visited)) return true;
        }
        return false;
    }

    private boolean dfs(int src, List<List<Integer>> adj, boolean[] path, boolean[] visited){
        if(path[src]) return true;
        if(visited[src]) return false;
        visited[src] = true;
        path[src] = true;
        for(int ngb : adj.get(src)){
            if(dfs(ngb, adj, path, visited)) return true;
        }
        path[src] = false;
        return false;
    }
}