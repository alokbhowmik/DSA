package LinkedList;

/*
*
* Problem Name : Add Number Linked Lists
* Problem Link : https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1
*
* Problem statement
*
* Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
Output:  3 -> 9 -> 0

Explanation: Given numbers are 45 and 345. There sum is 390.
Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7
Output: 7 -> 0

Explanation: Given numbers are 63 and 7. There sum is 70.
Constraints:
1 <= size of both linked lists <= 10^6
0 <= elements of both linked lists <= 9
* */
public class AddNumberLinkedLists {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    static Node reverse(Node node){
        Node prev = null;
        Node curr = node;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    Node addTwoLists(Node num1, Node num2) {
        // code here
        Node h1 = reverse(num1), h2 = reverse(num2);
        int carry = 0, sum = 0;
        Node nh = null, temp=null;
        while(h1 != null && h2 != null){
            sum = h1.data + h2.data + carry;
            int data = sum % 10;
            carry = sum / 10;
            if(nh == null){
                nh   = new Node(data);
                temp = nh;
            }else{
                temp.next = new Node(data);
                temp = temp.next;
            }
            h1 = h1.next;
            h2 = h2.next;
        }

        while(h1 != null){
            sum = h1.data + carry;
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
            h1 = h1.next;
        }

        while(h2 != null){
            sum = h2.data + carry;
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
            h2 = h2.next;
        }
        while(carry > 0){
            temp.next = new Node(carry % 10);
            temp = temp.next;
            carry /= 10;
        }
        nh =  reverse(nh);
        while(nh != null){
            if(nh.data != 0) return nh;
            nh = nh.next;
        }
        return nh;
    }
}
