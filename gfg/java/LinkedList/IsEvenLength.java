package gfg.java.LinkedList;

/**
 * 
 * Problem Name : Is Even Length
 * Problem Link : https://www.geeksforgeeks.org/problems/linked-list-length-even-or-odd/1
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */

public class IsEvenLength {
    public boolean isLengthEven(Node head) {
        // code here
        int cnt = 0;
        while(head != null){
            cnt++;
            head = head.next;
        }
        return cnt %2 == 0;
    }
}
