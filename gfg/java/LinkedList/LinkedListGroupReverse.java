package LinkedList;
/*
*
* Problem Name : Linked List Group Reverse
*
* Problem Link : https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
*
* Problem Statement
*
* Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed.

Examples:

Input: head = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8, k = 4
Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5

Explanation: The first 4 elements 1, 2, 2, 4 are reversed first and then the next 4 elements 5, 6, 7, 8. Hence, the resultant linked list is 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5.
Input: head = 1 -> 2 -> 3 -> 4 -> 5, k = 3
Output: 3 -> 2 -> 1 -> 5 -> 4

Explanation: The first 3 elements 1, 2, 3 are reversed first and then left out elements 4, 5 are reversed. Hence, the resultant linked list is 3 -> 2 -> 1 -> 5 -> 4.
Constraints:
1 <= size of linked list <= 10^5
1 <= data of nodes <= 10^6
1 <= k <= size of linked list
 *
* */
public class LinkedListGroupReverse {
    class Node
    {
        int data;
        Node next;
        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    private static Node reverseNode(Node head){
        Node curr = head, prev = null;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static Node reverseKGroup(Node head, int k) {
        // code here
        // tail        nh      h        nxt
        // <-1 <- 2 <- 3    <- 4 <- 5 k = 3
     //                             p  c
        // count = 2
        // nh
        // 3 -> 2 -> 1 -> 5 -> 4 -> null
        //                   tail
        // TC = O(n) SC = O(1)
        Node newHead = null, tail = null, curr = head, prev = null;
        int count = 0;
        if (k == 1) return head;
        while (curr != null) {
            count = 0;
            prev = null;
            while (curr != null && count < k) {
                prev = curr;
                curr = curr.next;
                count++;
            }
            if (prev != null) prev.next = null;
            Node revHead = reverseNode(head);
            if (newHead == null) {
                newHead = revHead;
            } else {
                tail.next = revHead;
            }
            tail = head;
            head = curr;

        }
        return newHead;
    }
}
