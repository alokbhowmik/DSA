package graph;

import java.util.*;

/*
*Problem Name : BFS of graph
*
*Problem Link : https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?_gl=1*y34lgo*_up*MQ..*_gs*MQ..&gclid=CjwKCAjwnei0BhB-EiwAA2xuBvXs4kprlF1EQOn1w3UUNNyKFP5ljE_fIf9xXO8P0Jy_hdGt_yuaYRoClxoQAvD_BwE
*
*Problem Statement : 
*
* Given a connected undirected graph represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.

Examples:

Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 3, 1, 4]
Explanation: Starting from 0, the BFS traversal will follow these steps:
Visit 0 → Output: 0
Visit 2 (first neighbor of 0) → Output: 0, 2
Visit 3 (next neighbor of 0) → Output: 0, 2, 3
Visit 1 (next neighbor of 0) → Output: 0, 2, 3,
Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4
Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the BFS traversal proceeds as follows:
Visit 0 → Output: 0
Visit 1 (the first neighbor of 0) → Output: 0, 1
Visit 2 (the next neighbor of 0) → Output: 0, 1, 2
Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3
Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4
Constraints:
1 ≤ adj.size() ≤ 10^4
1 ≤ adj[i][j] ≤ 10^4
*
* Approach 1 
*--------------
*TC = O(n) SC = O(n)
*/
public class BFSOfGraph{
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> seen      = new HashSet<>();

        bfs(0,adj, res, seen);
        return res;
    }

    private void bfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res, Set<Integer> seen){
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        seen.add(node);

        while(!que.isEmpty()){
            int currNode = que.poll();
            res.add(currNode);
            for(int ngb : adj.get(currNode)){
                if(!seen.contains(ngb)){
                    que.add(ngb);
                    seen.add(ngb);
                }
            }
        }
    }
}