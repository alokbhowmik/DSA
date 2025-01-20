package gfg.java.LinkedList;

/**
 * 
 * Problem Name : Palindrome Linked List
 * Problem Link : https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
 * Problem Statement 
 * ========================
 * 
 * Given a singly linked list of integers. The task is to check if the given linked list is palindrome or not.

Examples:

Input: LinkedList: 1->2->1->1->2->1
Output: true
Explanation: The given linked list is 1->2->1->1->2->1 , which is a palindrome and Hence, the output is true.

Input: LinkedList: 1->2->3->4
Output: false
Explanation: The given linked list is 1->2->3->4, which is not a palindrome and Hence, the output is false.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1) 
Note: You should not use the recursive stack space as well

Constraints:
1 <= number of nodes <= 10^5
1 ≤ node->data ≤ 10^3

Time Complexity : O(n)
Space Complexity : O(1)
 */
public class PalindromLinkedList {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    private Node reverse(Node head){
        Node prev = null, curr = head;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    boolean isPalindrome(Node head) {
        // Your code here
        
        Node fast = head, slow = head, new_head = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null){ // Even case
          new_head = reverse(slow);
        }else{ // Odd case 
            new_head = reverse(slow.next);
        }
        while(new_head != null){
            if(new_head.data != head.data) return false;
            head = head.next;
            new_head = new_head.next;
        }
        return true;
    }
}
