package LinkedList;

/*
*Problem Name : Prime List
*
*Problem Link : https://www.geeksforgeeks.org/problems/prime-list--170646/1
*
*Problem Statement : 
*
* You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime number. If more than one prime number exists at an equal distance, choose the smallest one. Return the head of the modified linked list.

Examples :

Input: head = 2 → 6 → 10
Output: 2 → 5 → 11

Explanation: The nearest prime of 2 is 2 itself. The nearest primes of 6 are 5 and 7, since 5 is smaller so, 5 will be chosen. The nearest prime of 10 is 11.
Input: head = 1 → 15 → 20
Output: 2 → 13 → 19

Explanation: The nearest prime of 1 is 2. The nearest primes of 15 are 13 and 17, since 13 is smaller so, 13 will be chosen. The nearest prime of 20 is 19.
Constraints:
1 <= no. of Nodes <= 10^4
1 <= node.val <= 10^4
*
* Approach 1 
*--------------
*TC = O(n*sqrt(num)) SC = O(1)
*/
public class PrimeList{
    private class Node{
        Node next;
        int val;
        public Node(int data){
            val=data;
            next=null;
        }
    }
    Node primeList(Node head) {
        // code here
        Node curr = head;
        while(curr != null){
            if(!isPrime(curr.val)){
                int nearestPrimeNum = findNearestPrime(curr.val);
                curr.val = nearestPrimeNum;
            }

            curr = curr.next;
        }
        return head;
    }
    private int findNearestPrime(int num){
        int temp1 = num;
        int temp2 = num;
        while(!isPrime(temp1) && !isPrime(temp2)){
            temp1--;
            temp2++;
        }
        int dist1 = Integer.MAX_VALUE;
        int dist2 = Integer.MAX_VALUE;

        if(isPrime(temp1)){
            dist1 = Math.min(dist1, Math.abs(num - temp1));
        }

        if(isPrime(temp2)){
            dist2 = Math.min(dist2, Math.abs(num - temp2));
        }
        return dist1 <= dist2 ? temp1 : temp2;
    }
    private boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2 || num == 3) return true;
        for(int i = 2; i<= (int)Math.sqrt(num); i++){
            if(num %i == 0) return false;
        }
        return true;
    }
}