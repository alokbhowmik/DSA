package LeetCode.java.priorityQueue;

import java.util.*;

/**
 * 
 * Problem Name : Smallest Range Covering Elements from K Lists
 * Problem Link : https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
 * 
 * Problem Statement 
 * 
 * You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

 

Example 1:

Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
Example 2:

Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
Output: [1,1]
 

Constraints:

nums.length == k
1 <= k <= 3500
1 <= nums[i].length <= 50
-10^5 <= nums[i][j] <= 10^5
 * nums[i] is sorted in non-decreasing order.
 * Time Complexity : O(n*log(k))
 * Space Complexity : O(K)
 */
public class SmallestRangeCoverInKList {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return a[0] - b[0];
        });

        int max = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;

        for(int i=0; i< nums.size(); i++){
            int num = nums.get(i).get(0);
            pq.offer(new int[]{num, i, 0});
            max = Math.max(max, num);
        }
        minRange = Math.min(max - pq.peek()[0], minRange);
        int smallestRange[] = new int[]{pq.peek()[0], max};

        while(true){
            int[] ele = pq.poll();
            int row = ele[1], col = ele[2];
            if(col + 1 >= nums.get(row).size()){
                break;
            }
            int nextNum = nums.get(row).get(col + 1);
            max = Math.max(max, nextNum);
            pq.offer(new int[]{nextNum, row, col + 1});
            int range = max - pq.peek()[0];
            if(range < minRange){
                minRange = range;
                smallestRange[0] = pq.peek()[0];
                smallestRange[1] = max;
            }
        }
        return smallestRange;
    }
}
