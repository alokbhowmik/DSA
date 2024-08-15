package gfg.java.array;

/**
 * 
 * 
 * Problem Name : Sum of Middle elements of two sorted arrays
 * Problem Link : https://www.geeksforgeeks.org/problems/sum-of-middle-elements-of-two-sorted-arrays2305/1
 * 
 * Problem Statement : 
 * Given 2 sorted integer arrays arr1 and arr2 of the same size. Find the sum of the middle elements of two sorted arrays arr1 and arr2.

Examples:

Input: arr1 = [1, 2, 4, 6, 10], arr2 = [4, 5, 6, 9, 12]
Output: 11
Explanation: The merged array looks like [1, 2, 4, 4, 5, 6, 6, 9, 10, 12]. Sum of middle elements is 11 (5 + 6).
Input: arr1 = [1, 12, 15, 26, 38], arr2 = [2, 13, 17, 30, 45]
Output: 32
Explanation: The merged array looks like [1, 2, 12, 13, 15, 17, 26, 30, 38, 45]. Sum of middle elements is 32 (15 + 17).
Expected Time Complexity: O(log n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr1.size() == arr2.size() <= 103
1 <= arr1[i] <= 106
1 <= arr2[i] <= 106

Time Complexity = O(2N)~ O(N)
Space Complexity = O(N + 1) ~ O(N)
 */
public class SumOfMiddleTwoElementOfSortedArr {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int n = arr1.length;
        int dp[] = new int[n+1];
        int i=0, j = 0, k = 0;
        while(i < n && j < n && k < n + 1){
            if(arr1[i] < arr2[j]){
                dp[k] = arr1[i];
                i++;
            }else{
                dp[k] = arr2[j];
                j++;
            }
            k++;
        }
        return dp[n-1] + dp[n];
    }
}
