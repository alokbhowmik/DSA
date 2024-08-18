package LeetCode.java.priorityQueue;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 
 * Problem Name : Ugly Number II 264
 * Problem Link : https://leetcode.com/problems/ugly-number-ii/description/
 * 
 * Problem Statement :
 * 
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 

Constraints:

1 <= n <= 1690

Time Complexity : O(n * log(n))
Space Complexity : O(n)
 */
public class UglyNumberII {
     
    public int nthUglyNumber(int n) {
       int[] primes= {2, 3, 5};
       PriorityQueue<Long> pq = new PriorityQueue<>();
       HashSet<Long> visited = new HashSet<>();
       long curr = 1L;
       pq.add(curr);
       visited.add(curr);
       for(int i=0; i<n;i++){
        curr = pq.poll();
        for(int prime: primes){
            long newValue = prime * curr;
            if(!visited.contains(newValue)){
                visited.add(newValue);
                pq.add(newValue);
            }
        }
       }
        return (int)curr;
    }
}
