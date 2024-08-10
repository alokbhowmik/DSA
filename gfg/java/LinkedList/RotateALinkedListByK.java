package gfg.java.LinkedList;

/**
 * 
 * Problem Name : Rotate a Linked List
 * Prolem Link : https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1
 * 
 * Problem Statement : 
 * Given the head of a singly linked list, the task is to rotate the linked list clockwise by k nodes, i.e., left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.

Examples:

Input: linkedlist: 2->4->7->8->9 , k = 3
Output: 8->9->2->4->7
Explanation:
Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
Rotate 3: 8 -> 9 -> 2 -> 4 -> 7

Input: linkedlist: 1->2->3->4->5->6->7->8 , k = 4
Output: 5->6->7->8->1->2->3->4

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= number of nodes <= 103
1 <= node -> data <= 104
1 <= k <= number of nodes 

Time Complexity : O(n)
Space Complexity : O(1)
 */
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
public class RotateALinkedListByK {
    public Node rotate(Node head, int k) {
        // add code 
        Node curr = head;
        while(--k > 0){
            curr = curr.next;
            // k--;
        }
        Node temp = curr.next;
        curr.next = null;
        if(temp == null) return head;
        curr = head;
        head = temp;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = curr;
        return head;
    }
}