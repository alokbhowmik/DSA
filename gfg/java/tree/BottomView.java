package gfg.java.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem Name : BottomView of a Binary Tree 
 * Problem Link : https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 * 
 * Problem Statement
 * 
 * Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level traversal is considered. For example, in the below diagram, 3 and 4 are both the bottommost nodes at a horizontal distance of 0, here 4 will be considered.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree, the output should be 5 10 4 14 25.

Examples :

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation: First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.

Thus bottom view of the binary tree will be 3 1 2.
Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 40 20 60 30
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105

Time Complexity : O(n)
Space Complexity : O(n)
 */


public class BottomView {
    class Node {
        int data, hd;
        Node left = null, right = null;
        Node(int key) {
            this.data = key;
            this.hd = Integer.MAX_VALUE;
            this.left = null;
            this.right = null;
        }
    }
    class Pair{
        int level;
        int val;
        Pair(int level, int val){
            this.level = level;
            this.val = val;
        }
    }
    Map<Integer, Pair> map = new HashMap<>();
    int left = 0, right = 0;
    
    void solve(Node root, int hd, int level){
        if(root == null) return;
        left = Math.min(left, hd);
        right = Math.max(right, hd);
        if(map.get(hd) == null || map.get(hd).level <= level){
           map.put(hd, new Pair(level, root.data)); 
        }
        solve(root.left, hd-1, level + 1);
        solve(root.right, hd + 1, level + 1);
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        solve(root, 0, 0);
        // System.out.println(left + " : " + right);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=left; i<= right; i++){
            res.add(map.get(i).val);
        }
        return res;
    }
}
