package gfg.java.LinkedList;

/**
 * 
 * Problem Name : Add 1 to a Linked List Number
 * Problem Link : https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
 * 
 * Problem Statement 
 * 
 * You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Input: LinkedList: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= len(list) <= 105
0 <= list[i] <= 105

Time Complexity : O(n)
Space Complexity : O(1) excluding Auxiliary space due to Recurtion
 * 
 */
public class Add1ToALinkedList {
    private int carry = 0;
    void add(Node head){
        if(head == null) return ;
        int val;
        if(head.next == null){
            val = head.data + 1;
            carry = val / 10;
            head.data = val % 10;
            return;
        }
        add(head.next);
        val = head.data + carry;
        carry = val / 10;
        head.data = val % 10;
    }
    public Node addOne(Node head) {
        // code here.
        add(head);
        while(carry != 0){
            Node node = new Node(carry % 10);
            node.next = head;
            head = node;
            carry /= 10;
        }
        return head;
        
    }
}
