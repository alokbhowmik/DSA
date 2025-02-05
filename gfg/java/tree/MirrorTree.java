package tree;
/*
* Problem Name : Mirror Tree
* Problem Link : https://www.geeksforgeeks.org/problems/mirror-tree/1
*
* Problem Statement
*
* Given a binary tree, convert the binary tree to its Mirror tree.

Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.

Examples:

Input: root[] = [1, 2, 3, N, N, 4]
Output: [1, 3, 2, N, 4]
Explanation:

In the inverted tree, every non-leaf node has its left and right child interchanged.
Input: root[] = [1, 2, 3, 4, 5]
Output: [1, 3, 2, N, N, 5, 4]
Explanation:

In the inverted tree, every non-leaf node has its left and right child interchanged.
Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5
 * */
public class MirrorTree {
    class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    Node solve(Node root){
        if(root == null) return null;
        Node left  = solve(root.left);
        Node right = solve(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    void mirror(Node node) {
        // Your code here
        node = solve(node);
    }
}
