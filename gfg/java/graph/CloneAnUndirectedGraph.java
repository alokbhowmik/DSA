package graph;

import java.util.*;

/*
*Problem Name : Clone an Undirected Graph
*
*Problem Link : https://www.geeksforgeeks.org/problems/clone-graph/1
*
*Problem Statement : 
*
* Given a connected undirected graph represented by adjacency list, adjList[][] with n nodes, having a distinct label from 0 to n-1, where each adj[i] represents the list of vertices connected to vertex i.

Create a clone of the graph, where each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.

class Node {
    val: integer
    neighbors: List[Node]
}
Your task is to complete the function cloneGraph( ) which takes a starting node of the graph as input and returns the copy of the given node as a reference to the cloned graph.

Note: If you return a correct copy of the given graph, then the driver code will print true; and if an incorrect copy is generated or when you return the original node, the driver code will print false.

Examples :

Input: n = 4, adjList[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
Output: true
Explanation:

As the cloned graph is identical to the original one the driver code will print true.
Input: n = 3, adjList[][] = [[1, 2], [0], [0]]
Output: true
Explanation:

As the cloned graph is identical to the original one the driver code will print true.
Constraints:
1 ≤ n ≤ 104
0 ≤ no. of edges ≤ 10^5
0 ≤ adjList[i][j] < n
*
* Approach 1 : BFS
*--------------
*TC = O(n) SC = O(n)
*/
public class CloneAnUndirectedGraph{
    private class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    Node cloneGraph(Node node) {
        // code here
        Map<Node, Node> clone = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Queue<Node> que = new LinkedList<>();
        Node copy = new Node(node.val);
        que.add(node);
        clone.put(node, copy);
        while(!que.isEmpty()){
            Node top = que.poll();
            for(Node ngb : top.neighbors){
                if(!clone.containsKey(ngb)){
                    clone.put(ngb, new Node(ngb.val));
                    que.add(ngb);
                }
            }
        }
        que.add(node);
        visited.add(clone.get(node));
        while(!que.isEmpty()){
            Node curr = que.poll();
            for(Node ngb : curr.neighbors){
                if(!visited.contains(clone.get(ngb))){
                    visited.add(clone.get(ngb));
                    que.add(ngb);

                }
                clone.get(curr).neighbors.add(clone.get(ngb));
            }
        }
        return clone.get(node);
    }
}