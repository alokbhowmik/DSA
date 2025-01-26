package LinkedList;
/*
*  Problem Name : Remove loop in Linked List
*
*  Problem Link : https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
*
* Problem Statement
* Given the head of a linked list that may contain a loop.  A loop means that the last node of the linked list is connected back to a node in the same list. The task is to remove the loop from the linked list (if it exists).

Custom Input format:

A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.

The generated output will be true if there is no loop in list and other nodes in the list remain unchanged, otherwise, false.

Examples:

Input: head = 1 -> 3 -> 4, pos = 2
Output: true
Explanation: The linked list looks like

A loop is present in the list, and it is removed.
Input: head = 1 -> 8 -> 3 -> 4, pos = 0
Output: true
Explanation:

The Linked list does not contains any loop.
Input: head = 1 -> 2 -> 3 -> 4, pos = 1
Output: true
Explanation: The linked list looks like

A loop is present in the list, and it is removed.
Constraints:
1 ≤ size of linked list ≤ 10^5
*
*
* TC = O(n) SC = O(1)
 * */
public class RemoveLoopInLinkedList {
    class Node
    {
        int data;
        Node next;
    }
    public static void removeLoop(Node head) {
        Node curr = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (curr != null) {
                    if (slow == curr) {
                        while (curr != null && curr.next != null) {
                            if (curr.next == slow) {
                                curr.next = null;
                                return;
                            }
                            curr = curr.next;
                        }
                    }
                    curr = curr.next;
                    slow = slow.next;
                }
            }
        }
    }
}