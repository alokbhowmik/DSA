package tree;
import tree.TreeNode.Node;
import java.util.ArrayList;

/*
* Problem Name : Inorder Traversal
*
* Problem Link : https://www.geeksforgeeks.org/problems/inorder-traversal/1
*
* Problem Statement
*
* Given a Binary Tree, your task is to return its In-Order Traversal.

An inorder traversal first visits the left child (including its entire subtree), then visits the node, and finally visits the right child (including its entire subtree).

Examples:

Input: root[] = [1, 2, 3, 4, 5]

Output: [4, 2, 5, 1, 3]
Explanation: The in-order traversal of the given binary tree is [4, 2, 5, 1, 3].
Input: root[] = [8, 1, 5, N, 7, 10, 6, N, 10, 6]

Output: [1, 7, 10, 8, 6, 10, 5, 6]
Explanation: The in-order traversal of the given binary tree is [1, 7, 10, 8, 6, 10, 5, 6].
Constraints:
1 <= number of nodes <= 10^5
0 <= node->data <= 10^5
 *
* */
public class InorderTraversal {

    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> res = new ArrayList<>();
        solve(root, res);
        return res;
    }

    private void solve(Node root, ArrayList<Integer> res){
        if(root == null) return;
        solve(root.left, res);
        res.add(root.data);
        solve(root.right, res);
    }
}
