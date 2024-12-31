
package gfg.java.array;
/*
*  Problem Name : Longest Consecutive Subsequence
*  Problem Link : https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
*  Problem Statement
*
* Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Examples:

Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
Output: 6
Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
Output: 4
Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.
Input: arr[] = [15, 13, 12, 14, 11, 10, 9]
Output: 7
Explanation: The longest consecutive subsequence is 9, 10, 11, 12, 13, 14, 15, which has a length of 7.
Constraints:
1 <= arr.size() <= 10^5
0 <= arr[i] <= 10^5
*
*
* */
public class LongestConsicutiveSubArray {

    public int longestConsecutive(int[] arr) {
        // code here
        int max = 0;
        for(int num : arr) max = Math.max(max, num);
        int arr1[] = new int[max + 1];

        for(int num : arr){
            arr1[num] = 1;
        }

        int cnt = 0, maxc = 0;
        for(int num : arr1){
            if(num == 1){
                cnt++;
            }else{
                cnt = 0;
            }
            maxc = Math.max(maxc, cnt);
        }
        // TC = O(n) SC = O(n)
        return maxc;
    }
}
