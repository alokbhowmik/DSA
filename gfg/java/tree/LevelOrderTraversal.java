package tree;
import java.util.*;

/*
*
* Problem Name : Level order traversal
*
* Problem Link : https://www.geeksforgeeks.org/problems/level-order-traversal/1
*
* Problem Statement
*Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.

Examples:

Input: root[] = [1, 2, 3]

Output: [[1], [2, 3]]
Input: root[] = [10, 20, 30, 40, 50]

Output: [[10], [20, 30], [40, 50]]
Input: root[] = [1, 3, 2, N, N, N, 4, 6, 5]

Output: [[1], [3, 2], [4], [6, 5]]
Constraints:

1 ≤ number of nodes ≤ 10^5
0 ≤ node->data ≤ 10^9
*
 * */
public class LevelOrderTraversal {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        Queue<Node> que = new LinkedList();
        que.add(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        while(!que.isEmpty()){
            int size = que.size();
            ArrayList<Integer> level = new ArrayList<>();
            while(size-- > 0){
                Node node = que.remove();
                level.add(node.data);
                if(node.left != null)
                    que.add(node.left);
                if(node.right != null)
                    que.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
