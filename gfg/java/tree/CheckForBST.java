package tree;

import java.util.ArrayList;
import tree.TreeNode.Node;

/*
*
* Problem Name : Check for BST
*
* Problem Link : https://www.geeksforgeeks.org/problems/check-for-bst/1
*
* Problem Statement
*
* Given the root of a binary tree. Check whether it is a BST or not.
Note: We are considering that BSTs can not contain duplicate Nodes.
A BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Examples:

Input: root = [2, 1, 3, N, N, N, 5]


Output: true
Explanation: The left subtree of every node contains smaller keys and right subtree of every node contains greater keys. Hence, the tree is a BST.
Input: root = [2, N, 7, N, 6, N, 9]



Output: false
Explanation: Since the node to the right of node with key 7 has lesser key value, hence it is not a valid BST.
Input: root = [10, 5, 20, N, N, 9, 25]


Output: false
Explanation: The node with key 9 present in the right subtree has lesser key value than root node.
Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^9
* */
public class CheckForBST {
    void inorderTraversal(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        inorderTraversal(root.left, ans);
        ans.add(root.data);
        inorderTraversal(root.right, ans);
    }
    boolean isBST(Node root) {
//         code here.
         ArrayList<Integer> ans = new ArrayList<>();
         inorderTraversal(root, ans);
         // System.out.println(ans);
         for(int i = 1; i < ans.size(); i++){
             if(ans.get(i) <= ans.get(i - 1) ) return false;
         }
         return true;
    }
}
