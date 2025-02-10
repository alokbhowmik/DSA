package tree;
import java.util.*;
import tree.TreeNode.Node;
/*
*
* Problem Name : K Sum Paths
*
* Problem Link : https://www.geeksforgeeks.org/problems/k-sum-paths/1
*
* Problem Statement
*
* Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).

Examples:

Input: k = 7

Output: 3
Explanation: The following paths sum to k

Input: k = 3

Output: 2
Explanation:
Path 1 : 1 -> 2 (Sum = 3)
Path 2 : 3 (Sum = 3)


Constraints:

1 ≤ number of nodes ≤ 10^4
-100 ≤ node value ≤ 100
-10^9 ≤ k ≤ 10^9
* */
public class KSumPaths {
    private int count = 0;
    void solve(Node root, int k, int cs, Map<Integer, Integer> map){
        if(root == null) return ;
        cs += root.data;
        count += map.getOrDefault(cs - k, 0);
        map.put(cs, map.getOrDefault(cs, 0) + 1);
        solve(root.left, k, cs, map);
        solve(root.right, k, cs, map);
        map.put(cs, map.get(cs) - 1);

    }
    public int sumK(Node root, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        solve(root, k,0, map);
        return count;
    }
}
