package LinkedList;
import java.util.*;

/*
*
*
* Problem Name : Detect Loop in linked list
*
* Problem Link : https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
*
* Problem Statement :
* You are given the head of a singly linked list. Your task is to determine if the linked list contains a loop. A loop exists in a linked list if the next pointer of the last node points to any other node in the list (including itself), rather than being null.

Custom Input format:
A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.

Examples:         ------
                  |    |
Input: head: 1 -> 3 -> 4, pos = 2
Output: true
Explanation: There exists a loop as last node is connected back to the second node.

Input: head: 1 -> 8 -> 3 -> 4, pos = 0
Output: false
Explanation: There exists no loop in given linked list.
             ----------------
      *      |              |
Input: head: 1 -> 2 -> 3 -> 4, pos = 1
Output: true
Explanation: There exists a loop as last node is connected back to the first node.


Constraints:
1 ≤ number of nodes ≤ 104
1 ≤ node->data ≤ 103
0 ≤ pos ≤ Number of nodes in Linked List
 * */
public class DetectLoopInLinkedList {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    public static boolean detectLoop(Node head) {
        // Add code here
        // TC = O(n) SC = O(n)
//        Set<Node> set = new HashSet<>();
//        Node curr = head;
//        while(curr != null){
//            if(set.contains(curr)) return true;
//            set.add(curr);
//            curr = curr.next;
//        }
//        return false;

        // Approach 2 : Tc = O(n) SC = O(1)
        Node fast = head, slow = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
