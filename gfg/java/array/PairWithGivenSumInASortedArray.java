package array;

import java.util.*;

/*
*
* Problem Name : Pair with given sum in a sorted array
* Problem Link : https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1
*
* Problem statement
*
*
* You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes.

Examples :

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: There are 2 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.
Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.
Input: arr[] = [-1, 10, 10, 12, 15], target = 125
Output: 0
Explanation: There is no such pair which sums up to 4.
Constraints:
-10^5 <= target <=10^5
 2 <= arr.size() <= 10^5
-10^5 <= arr[i] <= 10^5
*
* */
public class PairWithGivenSumInASortedArray {

    int countPairs(int arr[], int target) {
        // Approach 1 : TC = O(n) SC = O(n)
        int ans = 0;
         Map<Integer, Integer> map = new HashMap<>();
         for(int num : arr){
             ans += map.getOrDefault(target - num, 0);
             map.put(num, map.getOrDefault(num, 0) + 1);
         }
         return ans;
    }
}
