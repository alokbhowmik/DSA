package tree;

public class TreeNode {
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
}
