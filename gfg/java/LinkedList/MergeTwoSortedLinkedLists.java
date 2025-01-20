package LinkedList;

/*
*
*
* Problem Name : Merge two sorted linked lists
*
* Problem Link : https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
*
* Problem statement
*
* Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.

Examples:

Input: head1 = 5 -> 10 -> 15 -> 40, head2 = 2 -> 3 -> 20
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
Explanation:

Input: head1 = 1 -> 1, head2 = 2 -> 4
Output: 1 -> 1 -> 2 -> 4
Explanation:

Constraints:
1 <= no. of nodes<= 10^3
0 <= node->data <= 10^5
 *
* */
public class MergeTwoSortedLinkedLists {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    Node sortedMerge(Node head1, Node head2) {
        // code here TC = O(m + m) SC = O(1)
        Node nh = null, temp = null, next = null;
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                next = head1.next;
                head1.next = null;
                if(nh == null){
                    nh = head1;
                    temp = head1;
                }else{
                    temp.next = head1;
                    temp = temp.next;
                }
                head1 = next;
            }else{
                next = head2.next;
                head2.next = null;
                if(nh == null){
                    nh = head2;
                    temp = head2;
                }else{
                    temp.next = head2;
                    temp = temp.next;
                }
                head2 = next;
            }
        }
        if(head1 != null) temp.next = head1;
        if(head2 != null) temp.next = head2;
        return nh;
    }
}
