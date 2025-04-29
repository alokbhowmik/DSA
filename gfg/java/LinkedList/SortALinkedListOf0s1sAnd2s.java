package LinkedList;

/*
*Problem Name : Sort a linked list of 0s 1s and 2s
*
*Problem Link : https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
*
*Problem Statement : 
*
* Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2

Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2

Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between.
Input: head = 2 → 2 → 0 → 1

Output: 0 → 1 → 2 → 2

Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be 0 → 1 → 2 → 2.
Constraints:
1 ≤ no. of nodes ≤ 10^6
0 ≤ node->data ≤ 2


* Approach 1 
*--------------
*TC = O(n) SC = O(n)
*/
public class SortALinkedListOf0s1sAnd2s{
    private class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    private Node curr = null;
    Node segregate(Node head) {
        // code here
        int zero = 0, one = 0, two = 0;
        curr = head;
        while(curr != null){
            if(curr.data == 0) zero++;
            else if(curr.data == 1) one++;
            else if(curr.data == 2) two++;
            curr = curr.next;
        }
        // System.out.println("zero = " + zero + "one = " + one + "two=" + two);
        Node start = addNode(zero, 0, null);

        start = addNode(one, 1, start);
        start = addNode(two, 2, start);
        return start;
    }

    private Node addNode(int times, int value, Node start){

        while(times > 0){
            Node node = new Node(value);
            if(start == null){
                start = node;
            }else{
                curr.next = node;
            }
            curr = node;
            times--;
        }
        return start;
    }
}