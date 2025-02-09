package gfg.java.LinkedList;

/**
 * 
 * 
 * Problem Name : Find length of Loop
 * Problem Link : https://www.geeksforgeeks.org/problems/find-length-of-loop/1
 * 
 * Problem Statement : 
 * Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.



Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist. If c is 0, then there is no loop.

Examples:

Input: LinkedList: 25->14->19->33->10->21->39->90->58->45, c = 4
Output: 7
Explanation: The loop is from 33 to 45. So length of loop is 33->10->21->39-> 90->58->45 = 7. 
The number 33 is connected to the last node of the linkedlist to form the loop because according to the input the 4th node from the beginning(1 based indexing) 
will be connected to the last node for the loop.
 
Input: LinkedList: 5->4, c = 0
Output: 0
Explanation: There is no loop.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= no. of nodes <= 10^6
0 <= node.data <=10^6
0 <= c<= n-1

Time Complexity = O(n)
Space Complexity = O(1)

 */
public class LengthOfALoop {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow = head, fast = head;
        int cnt = 0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                cnt++;
                while(slow.next != fast){
                    cnt++;
                    slow = slow.next;
                }
                return cnt;
            }
        }
        return 0;
    }
}
