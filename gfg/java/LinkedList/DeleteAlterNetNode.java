package gfg.java.LinkedList;


/**
 * 
 * Problem Name : Delete Alternate Nodes
 * Problem Link : https://www.geeksforgeeks.org/problems/delete-alternate-nodes/1
 * 
 * Problem Statement
 * 
 * Given a Singly Linked List, Delete all alternate nodes of the list ie delete all the nodes present in even positions.

Examples :

Input: LinkedList: 1->2->3->4->5->6
 
Output: 1->3->5

Explanation: Deleting alternate nodes ie 2, 4, 6 results in the linked list with elements 1->3->5.
Input: LinkedList: 99->59->42->20
 
Output: 99->42
 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= number of nodes <= 10^5
1 <= node->data <= 10^3

Time Complexity : O(N)
Space Complexity : O(1)
 */
class DeleteAlterNetNode {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    public void deleteAlt(Node head) {
        // Code Here
        Node fast = head;
        Node second = fast.next;
        while(fast != null && second != null){
            fast.next = second.next;
            fast = fast.next;
            if(fast != null)
            second = fast.next;
        }
        // return head;
    }
}