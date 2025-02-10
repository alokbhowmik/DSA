package tree;

import java.util.ArrayList;
import tree.TreeNode.Node;
/*
* Problem Name : Tree Boundary Traversal
 *
 * Problem Link : https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
 *
 * Problem Statement
 *
 * Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:

Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.

Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.

Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.

Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary.

Examples:

Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]
Explanation:

Input: root[] = [1, 2, N, 4, 9, 6, 5, N, 3, N, N, N, N 7, 8]
Output: [1, 2, 4, 6, 5, 7, 8]
Explanation:












As the root doesn't have a right subtree, the right boundary is not included in the traversal.
Input: root[] = [1, N, 2, N, 3, N, 4, N, N]
    1
     \
      2
       \
        3
         \
          4

Output: [1, 4, 3, 2]
Explanation:
Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5
* */
public class TreeBoundaryTraversal {
    boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    void leftTraversal(Node node, ArrayList<Integer> ans){
        if(node == null) return ;
        if(isLeaf(node)) return;
        ans.add(node.data);
        if(node.left != null){
            leftTraversal(node.left, ans);
        }else{
            leftTraversal(node.right, ans);
        }
    }

    void leafTraversal(Node node, ArrayList<Integer> ans){
        if(node == null) return ;
        if(isLeaf(node)){
            ans.add(node.data);
            return;
        }
        leafTraversal(node.left, ans);
        leafTraversal(node.right, ans);
    }

    void rightTraversal(Node node, ArrayList<Integer> ans){
        if(node == null) return;
        if(isLeaf(node)) return;
        if(node.right != null){
            rightTraversal(node.right, ans);
        }else{
            rightTraversal(node.left, ans);
        }
        ans.add(node.data);
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null) return ans;
        ans.add(node.data);
        if(isLeaf(node)) return ans;
        leftTraversal(node.left, ans);
        leafTraversal(node, ans);
        rightTraversal(node.right, ans);
        return ans;
    }
}
