package array;

import java.util.ArrayList;
import java.util.Arrays;

/*
*
* Problem Name : k largest elements
*
* Problem Link : https://www.geeksforgeeks.org/problems/k-largest-elements4206/1
*
* Problem Statement
*
* Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order.

Examples:

Input: arr[] = [12, 5, 787, 1, 23], k = 2
Output: [787, 23]
Explanation: 1st largest element in the array is 787 and second largest is 23.
Input: arr[] = [1, 23, 12, 9, 30, 2, 50], k = 3
Output: [50, 30, 23]
Explanation: Three Largest elements in the array are 50, 30 and 23.
Input: arr[] = [12, 23], k = 1
Output: [23]
Explanation: 1st Largest element in the array is 23.
Constraints:
1 ≤ k ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6
 * */
public class K_LargestElements {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = arr.length - 1; i>= arr.length - k; i--){
            res.add(arr[i]);
        }
        return res;
    }
}
