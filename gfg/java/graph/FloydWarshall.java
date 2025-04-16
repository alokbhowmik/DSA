package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
*Problem Name : Floyd Warshall
*
*Problem Link : https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
*
*Problem Statement : 
*
* ou are given an weighted directed graph, represented by an adjacency matrix, dist[][] of size n x n, where dist[i][j] represents the weight of the edge from node i to node j. If there is no direct edge, dist[i][j] is set to a large value (i.e., 108) to represent infinity.
The graph may contain negative edge weights, but it does not contain any negative weight cycles.

Your task is to find the shortest distance between every pair of nodes i and j in the graph.

Note: Modify the distances for every pair in place.

Examples :

Input: dist[][] = [[0, 4, 108, 5, 108], [108, 0, 1, 108, 6], [2, 108, 0, 3, 108], [108, 108, 1, 0, 2], [1, 108, 108, 4, 0]]

Output: [[0, 4, 5, 5, 7], [3, 0, 1, 4, 6], [2, 6, 0, 3, 5], [3, 7, 1, 0, 2], [1, 5, 5, 4, 0]]

Explanation: Each cell dist[i][j] in the output shows the shortest distance from node i to node j, computed by considering all possible intermediate nodes.
Input: dist[][] = [[0, -1, 2], [1, 0, 108], [3, 1, 0]]

Output: [[0, -1, 2], [1, 0, 3], [2, 1, 0]]

Explanation: Each cell dist[i][j] in the output shows the shortest distance from node i to node j, computed by considering all possible intermediate nodes.
From 2 to 0 shortest distance should be 2 by following path 2 -> 1 -> 0
From 1 to 2 shortest distance should be 3 by following path 1 -> 0 -> 2
Constraints:
1 ≤ dist.size() ≤ 100
-1000 ≤ dist[i][j] ≤ 1000

Expected Complexities
Time Complexity: O(n^3)
Auxiliary Space: O(1)
*
* Approach 1 
*--------------
*TC = O(n^2 log(n) ) SC = O(n)
*/
public class FloydWarshall{
    public void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length ;
        for(int i = 0; i < n; i++){
            dist[i][i] = 0;
        }
        for(int src = 0; src < n; src++){
            int[] arr = minDist(src, n, dist);// O((v + e)*n * log(v))
            for(int c =0; c < n; c++){
                dist[src][c] = arr[c]; // O(n * n)
            }
        }
    }

    int[] minDist(int src, int n, int[][] dist){
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b)->a[1] - b[1]
        );
        int[] ans = new int[n];
        Arrays.fill(ans, 1000000000);
        ans[src] = 0;
        pq.offer(new int[]{src, 0});
        while(!pq.isEmpty()){ // log(v)
            int top[] = pq.poll();
            int curr = top[0], d = top[1];
            for(int i = 0; i< n; i++){ // O(v + e)
                if(i == src) continue;
                if(ans[i] > d + dist[curr][i]){
                    ans[i] = d + dist[curr][i];
                    //System.out.println(dist[curr][i]);
                    pq.offer(new int[]{i, ans[i]});
                }
            }
        }

        return ans;

    }
}