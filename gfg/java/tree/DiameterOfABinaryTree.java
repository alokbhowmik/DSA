package tree;
/*
*
*   Problem Name : Diameter of a Binary Tree
*   Problem Link : https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1
*
*   Problem Statement
*Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.

Examples:

Input: root[] = [1, 2, 3]

Output: 2
Explanation: The longest path has 2 edges (node 2 -> node 1 -> node 3).

Input: root[] = [5, 8, 6, 3, 7, 9]

Output: 4
Explanation: The longest path has 4 edges (node 3 -> node 8 -> node 5 -> node 6 -> node 9).

Constraints:
1 ≤ number of nodes ≤ 10^5
0 ≤ node->data ≤ 10^5
*
*
 * */
public class DiameterOfABinaryTree {
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    int height = 0;
    int solve(Node root){
        if(root == null) return 0 ;
        int left = solve(root.left);
        int right = solve(root.right);

        height = Math.max(height, left + right);
        return Math.max(left, right) + 1;
    }
    int diameter(Node root) {
        // Your code here
        solve(root);
        return height;
    }
}
