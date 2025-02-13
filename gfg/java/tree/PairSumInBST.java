package tree;

import java.util.HashSet;
import java.util.Set;
import tree.TreeNode.Node;

/*
*
* Problem Name : Pair Sum in BST
*
* Problem Link : https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
*
* Problem Statement
*
* Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target.

Examples:

Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
       bst
Output: True
Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.
Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
          bst-3
Output: False
Explanation: In the binary tree above, there are no such two nodes exists that add up to 23.
Constraints:

1 ≤ Number of Nodes ≤ 10^5
1 ≤ target ≤ 10^6
 * */
public class PairSumInBST {
    boolean solve(Node root, int target, Set<Integer> set){
        if(root == null) return false;
        if(set.contains(target - root.data)) return true;
        set.add(root.data);
        return solve(root.left, target, set) ||
                solve(root.right, target, set);
    }
    boolean findTarget(Node root, int target) {
        // Write your code here
        return solve(root, target, new HashSet<>());
    }
}
