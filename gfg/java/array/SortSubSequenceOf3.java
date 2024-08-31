package gfg.java.array;

import java.util.*;

/**
 * 
 * Problem Statement : Sorted subsequence of size 3
 * Problem Link : https://www.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1
 * Problem Statement 
 * 
 * You are given an array arr, you need to find any three elements in it such that arr[i] < arr[j] < arr[k] and i < j < k.

Note:

The output will be 1 if the subsequence returned by the function is present in the array arr
If the subsequence is not present in the array then return an empty array, the driver code will print 0.
If the subsequence returned by the function is not in the format as mentioned then the output will be -1.
Examples :

Input: arr = [1, 2, 1, 1, 3]
Output: 1
Explanation: A subsequence 1 2 3 exist.
Input: arr = [1, 1, 3]
Output: 0
Explanation: No such Subsequence exist, so empty array is returned (the driver code automatically prints 0 in this case).
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= arr.size() <= 10^5
1 <= arr[i] <= 10^6

Time Complexity = O(n) 
Space Complexity = O(n)
 */
class SortSubSequenceOf3 {
    public List<Integer> find3Numbers(int[] arr) {
        // code here
       int n = arr.length;
       int leftMin[] = new int[n];
       int rightMax[] = new int[n];
       rightMax[n-1] = arr[n-1];
       leftMin[0] = arr[0];
       for(int i=1; i<n; i++){
           leftMin[i] = Math.min(leftMin[i-1], arr[i]);
       }
       for(int i=n-2; i>=0; i--){
           rightMax[i] = Math.max(rightMax[i+1], arr[i]);
       }
       ArrayList<Integer> res = new ArrayList<>();
       for(int i=0; i<n; i++){
           if(leftMin[i] < arr[i] && rightMax[i] > arr[i]){
               res.add(leftMin[i]);
               res.add(arr[i]);
               res.add(rightMax[i]);
               return res;
           }
       }
       return res;
    }
}