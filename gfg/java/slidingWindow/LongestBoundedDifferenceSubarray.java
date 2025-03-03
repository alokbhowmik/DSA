package slidingWindow;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
*Problem Name : Longest Bounded Difference Subarray
*
*Problem Link : https://www.geeksforgeeks.org/problems/longest-bounded-difference-subarray/1
*
*Problem Statement : 
*
*
* Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
If multiple such subarrays exist, return the one that starts at the smallest index.

Examples:

Input: arr[] = [8, 4, 2, 6, 7], x = 4
Output: [4, 2, 6]
Explanation: The sub-array described by index [1..3], i.e. [4, 2, 6] contains no such difference of two elements which is greater than 4.
Input: arr[] = [15, 10, 1, 2, 4, 7, 2], x = 5
Output: [2, 4, 7, 2]
Explanation: The sub-array described by indexes [3..6], i.e. [2, 4, 7, 2] contains no such difference of two elements which is greater than 5.
Constraints:
1 <= arr.size() <= 10^5
1 <= arr[i] <= 10^9
0 <= x<= 10^9


*
* Approach 1 
*--------------
*TC = O(n * log(n) ) SC = O(n)
*/
public class LongestBoundedDifferenceSubarray{
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b)->b[0] - a[0]);
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b)->a[0] - b[0]);
        int l = 0, r = 0;
        int start = 0, end = 0, maxSize = 0;
        while(r < arr.length){
            max.offer(new int[]{arr[r], r});
            min.offer(new int[]{arr[r], r});
            while(!max.isEmpty() && !min.isEmpty() && Math.abs(max.peek()[0] - min.peek()[0]) > x){
                while(!max.isEmpty() && max.peek()[1] <= l){
                    max.poll();
                }
                while(!min.isEmpty() && min.peek()[1] <= l){
                    min.poll();
                }
                l++;
            }
            if(r - l + 1 > maxSize){
                maxSize = r - l + 1;
                start = l;
                end = r;
            }
            r++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = start; i<=end; i++) list.add(arr[i]);
        return list;
    }
}