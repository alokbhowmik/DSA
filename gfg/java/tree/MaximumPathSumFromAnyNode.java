package tree;
import tree.TreeNode.Node;
/*
*
* Problem Name : Maximum path sum from any node
*
* Problem Link : https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1
*
* Problem Statement
*
* Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Examples:

Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
Output: 42
Explanation:

Max path sum is represented using green colour nodes in the above binary tree.
Input: root[] = [-17, 11, 4, 20, -2, 10]
Output: 31
Explanation:

Max path sum is represented using green colour nodes in the above binary tree.
Constraints:
1 ≤ number of nodes ≤ 103
-10^4 ≤ node->data ≤ 10^4
* */
public class MaximumPathSumFromAnyNode {
    int maxSum = Integer.MIN_VALUE;

    int solve(Node root){
        if(root == null) return 0;
        int ls = solve(root.left);
        int rs = solve(root.right);
        int temp = Math.max(0, Math.max(ls, rs));
        maxSum = Math.max(maxSum, Math.max(temp + root.data, ls + rs + root.data));
        return temp + root.data;
    }
    int findMaxSum(Node node) {
        // your code goes here
        solve(node);
        return maxSum;
    }
}
