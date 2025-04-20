package DSU;

import java.util.*;

/*
*Problem Name : Minimum Weight Cycle
*
*Problem Link : https://www.geeksforgeeks.org/problems/minimum-weight-cycle/1
*
*Problem Statement : 
*
* Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents the edge between the nodes u and v having w edge weight.
Your task is to find the minimum weight cycle in this graph.

Examples:

Input: V = 5, edges[][] = [[0, 1, 2], [1, 2, 2], [1, 3, 1], [1, 4, 1], [0, 4, 3], [2, 3, 4]]

Output: 6
Explanation:

Minimum-weighted cycle is  0 → 1 → 4 → 0 with a total weight of 6(2 + 1 + 3)
Input: V = 5, edges[][] = [[0, 1, 3], [1, 2, 2], [0, 4, 1], [1, 4, 2], [1, 3, 1], [3, 4, 2], [2, 3, 3]]

Output: 5
Explanation:

Minimum-weighted cycle is  1 → 3 → 4 → 1 with a total weight of 5(1 + 2 + 2)
Constraints:
1 ≤ V ≤ 100
1 ≤ E = edges.size() ≤ 10^3
1 ≤ edges[i][j] ≤ 100
*
* Approach 1 
*--------------
*TC = O((V + E)log(V + E)) SC = O(V + E)
*/
public class MinimumWeightCycle{
    private class DSU{
        private int parent[] , size[];
        private Map<Integer, List<int[]>> adj ;
        private int n;
        DSU(int n){
            this.n = n;
            this.parent = new int[n];
            this.size   = new int[n];
            adj = new HashMap<>();
            for(int i = 0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
                adj.put(i, new ArrayList<>());
            }
        }

        int find(int u){
            if(u == parent[u]) return u;
            return parent[u]=find(parent[u]);
        }

        boolean union(int u, int v, int w){
            int parent_u = find(u);
            int parent_v = find(v);
            if(parent_u == parent_v) return false;
            if(size[parent_u] >= size[parent_v]){
                size[parent_u] += size[parent_v];
                parent[parent_v] = parent_u;
            }else{
                size[parent_v] += size[parent_u];
                parent[parent_u] = parent_v;
            }
            add(u, v, w) ;
            return true;
        }

        void add(int u,int v, int w){
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int findMinWeight(int u, int v, int w){
            int weight[] = new int[this.n];
            Arrays.fill(weight, Integer.MAX_VALUE);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1] - b[1]);
            pq.offer(new int[]{u, 0});
            weight[u] = 0;
            while(!pq.isEmpty()){
                int[] top = pq.poll();
                int curr = top[0], wt = top[1];
                if(curr == v) return w + wt;
                // System.out.println(map.get(curr));
                for(int[] edge : adj.get(curr)){
                    if(edge[1] + wt < weight[edge[0]]){
                        pq.offer(new int[]{edge[0], edge[1] + wt});
                        weight[edge[0]] = edge[1] + wt ;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
    }
    public int findMinCycle(int V, int[][] edges) {
        // code here
        DSU dsu = new DSU(V);
        int minWeightCycle = Integer.MAX_VALUE;
        // System.out.println(edges);
        for(int i = 0; i < edges.length ; i+= 2){
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if(!dsu.union(u, v, w)){
                minWeightCycle = Math.min(
                        minWeightCycle,
                        dsu.findMinWeight(u, v, w)
                );
                dsu.add(u, v, w);
            }
        }
        return minWeightCycle;
    }
}