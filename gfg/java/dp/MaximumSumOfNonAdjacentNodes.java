package dp;

import java.util.HashMap;
import java.util.Map;

/*
*Problem Name : Maximum sum of Non adjacent nodes
*
*Problem Link : https://www.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1
*
*Problem Statement : 
*
* Given a binary tree with a value associated with each node. Your task is to select a subset of nodes such that the sum of their values is maximized, with the condition that no two selected nodes are directly connected that is, if a node is included in the subset, neither its parent nor its children can be included.

Examples:

Input: root[] = [11, 1, 2]

Output: 11
Explanation: The maximum sum is obtained by selecting the node 11.

Input: root[] = [1, 2, 3, 4, N, 5, 6]

Output: 16
Explanation: The maximum sum is obtained by selecting the nodes 1, 4, 5, and 6, which are not directly connected to each other. Their total sum is 16.

Constraints:
1 ≤ no. of nodes in the tree ≤ 104
1 ≤ Node.val ≤ 10^5

*
* Approach 1 
*--------------
*TC = O(2^n) SC = O(1)
*
* Approach 2
*--------------
*TC = O(n) SC = O(n)
*/
public class MaximumSumOfNonAdjacentNodes{
    private class Node
    {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private Map<Node, Integer> map ;
    public int getMaxSum(Node root) {
        map = new HashMap<>();
        return solve(root);
    }
    private int solve(Node root){
        if(root == null) return 0 ;
        if(map.get(root) != null) return map.get(root);
        int take = root.data;
        if(root.left != null){
            take += solve(root.left.left);
            take += solve(root.left.right);
        }
        if(root.right != null){
            take += solve(root.right.left);
            take += solve(root.right.right);
        }
        int skip = solve(root.left) + solve(root.right);
        map.put(root, Math.max(take, skip));
        return map.get(root);
    }
}