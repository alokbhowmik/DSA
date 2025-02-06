package tree;

import java.util.HashMap;

/*
* Problem name : Construct Tree from Inorder & Preorder
*
* Problem Link : https://www.geeksforgeeks.org/problems/construct-tree-1/1
*
* Problem Statement
*
* Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.

Note: The output is written in postorder traversal.

Examples:

Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
Output: [8, 7, 6, 1]
Explanation: The tree will look like

Input: inorder[] = [3, 1, 4, 0, 2, 5], preorder[] = [0, 1, 3, 4, 2, 5]
Output: [3, 4, 1, 5, 2, 0]
Explanation: The tree will look like

Input: inorder[] = [2, 5, 4, 1, 3], preorder[] = [1, 4, 5, 2, 3]
Output: [2, 5, 4, 3, 1]
Explanation: The tree will look like

Constraints:
1 ≤ number of nodes ≤ 103
0 ≤ nodes -> data ≤ 103
Both the inorder and preorder arrays contain unique values.
*
* */
public class ConstructTreeFromInorderAndPreorder {
    class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }
    public Node buildTree(int inorder[], int preorder[]) {
        HashMap < Integer , Integer > map = new HashMap<>();

        for(int i = 0;i<inorder.length;i++){
            map.put (inorder[i] , i );
        }
        return split( inorder , 0,inorder.length-1 ,preorder , 0, map);
    }

    public Node split(int []inorder , int instart, int inend , int[] preorder, int index , HashMap<Integer , Integer> map ){
        Node root = new Node (preorder[index]);

        int mid = map.get (root.data);
        if(mid>instart){
            root.left = split(inorder, instart , mid-1,preorder, index+1,map );
        }
        if(mid<inend){
            root.right = split(inorder , mid+1, inend ,preorder ,index + mid - instart +1,map);
        }

        return root;
    }
}
