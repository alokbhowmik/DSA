package tree;
import java.util.*;
/*
*
* Problem Name : Height of Binary Tree
*
* Problem Link : http://geeksforgeeks.org/problems/height-of-binary-tree/1
*
* Problem Statement
*
* Given a binary tree, find its height.

The height of a tree is defined as the number of edges on the longest path from the root to a leaf node. A leaf node is a node that does not have any children.

Examples:

Input: root[] = [12, 8, 18, 5, 11]

Output: 2
Explanation: One of the longest path from the root (node 12) goes through node 8 to node 5, which has 2 edges.
Input: root[] = [1, 2, 3, 4, N, N, 5, N, N, 6, 7]

Output: 3
Explanation: The longest path from the root (node 1) to a leaf node 6 with 3 edge.
Constraints:
1 <= number of nodes <= 10^5
0 <= node->data <= 10^5
 * */
public class HeightOfBinaryTree {
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
    int height(Node node) {
        // code here
        if(node.left == null && node.right == null) return 0 ;
        int left  = node.left  == null ? 0 : height(node.left);
        int right = node.right == null ? 0 : height(node.right);
        return Math.max(left, right) + 1;
    }

    int bfs(Node node){
        Queue<Node> que = new LinkedList<>();
        int height = -1;
        que.offer(node);
        while(!que.isEmpty()){
            int size = que.size();
            height++;
            while(size-- > 0){
                Node curr = que.poll();
                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
            }
        }
        return height;
    }
}
