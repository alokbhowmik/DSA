package LeetCode.java.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @PostOrderTraversal
 * 
 * Problem Name : Binary Tree Postorder Traversal 145
 * Problem Link : https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * Problem Statement : 
 * 
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
Appraoach : Recursive 
Time Complexity : O(n)
Space Complexity : O(1)
 */
public class PostOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<Integer> res = new ArrayList<>();

    void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
}
