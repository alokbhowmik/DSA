package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tree.TreeNode.Node;

/*
*
* Problem Name : Fixing Two nodes of a BST
*
* Problem Link : https://www.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1
*
* Problem Statement
*
* Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original linked list.

Examples :
Input: root = [10, 5, 8, 2, 20]

Output: 1


Explanation: The nodes 20 and 8 were swapped.
Input: root = [5, 10, 20, 2, 8]

Output: 1

Explanation: The nodes 10 and 5 were swapped.
Constraints:
1 ≤ Number of nodes ≤ 10^3
 *
* */
public class FixingTwoNodesOfABST {
    void inorder(Node root, List<Integer> list){
        if(root == null) return ;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
    int i = 0;
    void builtBST(Node root, List<Integer> list){
        if(root == null) return;
        builtBST(root.left, list);
        root.data = list.get(i++);
        builtBST(root.right, list);
    }
    void correctBST(Node root) {
        // code here.
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        Collections.sort(list);
        builtBST(root, list);
    }
}
