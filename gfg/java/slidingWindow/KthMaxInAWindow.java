package gfg.java.slidingWindow;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 
 * Problem Name : K Sized Subarray Maximum
 * Problem Link : https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
 * 
 * Problem Statement 
 * 
 * Given an array arr[] and an integer k. Find the maximum for each and every contiguous subarray of size k.

Examples:

Input: k = 3, arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6]
Output: [3, 3, 4, 5, 5, 5, 6] 
Explanation: 
1st contiguous subarray = [1 2 3] max = 3
2nd contiguous subarray = [2 3 1] max = 3
3rd contiguous subarray = [3 1 4] max = 4
4th contiguous subarray = [1 4 5] max = 5
5th contiguous subarray = [4 5 2] max = 5
6th contiguous subarray = [5 2 3] max = 5
7th contiguous subarray = [2 3 6] max = 6

Input: k = 4, arr[] = [8, 5, 10, 7, 9, 4, 15, 12, 90, 13]
Output: [10, 10, 10, 15, 15, 90, 90]
Explanation: 
1st contiguous subarray = [8 5 10 7], max = 10
2nd contiguous subarray = [5 10 7 9], max = 10
3rd contiguous subarray = [10 7 9 4], max = 10
4th contiguous subarray = [7 9 4 15], max = 15
5th contiguous subarray = [9 4 15 12], max = 15
6th contiguous subarray = [4 15 12 90], max = 90
7th contiguous subarray = {15 12 90 13}, max = 90
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(k)

Constraints:
1 ≤ sizeof(arr) ≤ 10^6
1 ≤ k ≤ sizeof(arr)
0 ≤ arr[i] ≤ 10^9

Time Complexity : O(n)
Space Complexity : O(K)
 */
public class KthMaxInAWindow {
    class Pair implements Comparable<Pair>{
        int value, index;
        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
        public int compareTo(Pair p){
            return p.value - this.value;
        }
    }
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        while(j < n){
            pq.offer(new Pair(arr[j], j));
            if(j - i + 1 > k){
               while(j - i + 1 > k && pq.peek().index <= i){
                   pq.poll();
               } 
               i++;
            }
            if(j - i + 1 == k){
                res.add(pq.peek().value);
            }
            j++;
        }
        return res;
    }
}
