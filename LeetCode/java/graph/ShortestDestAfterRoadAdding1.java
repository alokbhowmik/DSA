package LeetCode.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Problem Name : Shortest Distance After Road Addition Queries I
 * Problem Link : https://leetcode.com/contest/weekly-contest-409/problems/shortest-distance-after-road-addition-queries-i/description/
 * 
 * Problem Statement
 * --------------------
 * 
 * You are given an integer n and a 2D integer array queries.

There are n cities numbered from 0 to n - 1. Initially, there is a unidirectional road from city i to city i + 1 for all 0 <= i < n - 1.

queries[i] = [ui, vi] represents the addition of a new unidirectional road from city ui to city vi. After each query, you need to find the length of the shortest path from city 0 to city n - 1.

Return an array answer where for each i in the range [0, queries.length - 1], answer[i] is the length of the shortest path from city 0 to city n - 1 after processing the first i + 1 queries.

 

Example 1:

Input: n = 5, queries = [[2,4],[0,2],[0,4]]

Output: [3,2,1]

Explanation:



After the addition of the road from 2 to 4, the length of the shortest path from 0 to 4 is 3.



After the addition of the road from 0 to 2, the length of the shortest path from 0 to 4 is 2.



After the addition of the road from 0 to 4, the length of the shortest path from 0 to 4 is 1.

Example 2:

Input: n = 4, queries = [[0,3],[0,2]]

Output: [1,1]

Explanation:



After the addition of the road from 0 to 3, the length of the shortest path from 0 to 3 is 1.



After the addition of the road from 0 to 2, the length of the shortest path remains 1.

 

Constraints:

3 <= n <= 500
1 <= queries.length <= 500
queries[i].length == 2
0 <= queries[i][0] < queries[i][1] < n
1 < queries[i][1] - queries[i][0]

Time Complexity = O(q * n)
Space Complexity = O(n)
 */
public class ShortestDestAfterRoadAdding1 {
    class Pair{
        int value;
        int step;
        Pair(int value, int step){
            this.value = value;
            this.step = step;
        }
    }
    void builtGraph(int n, HashMap<Integer, List<Integer>> map){
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<Integer>());
            map.get(i).add(i + 1);
        }
    }
    void updateGraph(int u, int v, HashMap<Integer, List<Integer>> map){
        map.get(u).add(v);
    }
    int shortestPath(int s, int d, HashMap<Integer, List<Integer>> map){
        // System.out.println("-------------------------------");
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[d+1];
        queue.add(new Pair(s, 0));
        visited[s] = true;
        while(!queue.isEmpty()){
            Pair node = queue.remove();
            if(node.value == d) return node.step;
            for(int ngb: map.get(node.value)){
                // System.out.println(ngb + ":" + d + "step =" + node.step );
                if(!visited[ngb]){
                    visited[ngb] = true;
                    queue.add(new Pair(ngb, node.step + 1));
                }
            }
        } 
        return -1;
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        builtGraph(n, map);
        int res[] = new int[queries.length];
        int i = 0;
        for(int[] query : queries){
            updateGraph(query[0], query[1], map);
            res[i] = shortestPath(0, n-1, map);
            i++;
        }
        return res;
    }
}
