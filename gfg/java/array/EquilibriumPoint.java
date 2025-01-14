package array;
/*
*
* Problem Name : Equilibrium Point
*
* Problem Link : https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
*
* Problem Statement
*
* Given an array arr[] of non-negative numbers. The task is to find the first equilibrium point in the array.

The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements before that index is the same as the sum of elements after it. Return -1 if no such point exists.

Examples:

Input: arr[] = [1, 2, 0, 3]
Output: 2
Explanation: The sum of left of index 2 is 1 + 2 = 3 and sum on right of index 2 is 0 + 3 = 3.
Input: arr[] = [1, 1, 1, 1]
Output: -1
Explanation: There is no equilibrium index in the array.
Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]
Output: 3
Explanation: The sum of left of index 3 is -7 + 1 + 5 = -1 and sum on right of index 3 is -4 + 3 + 0 = -1.
Constraints:
3 <= arr.size() <= 10^6
0 <= arr[i] <= 10^9
 *
* */
public class EquilibriumPoint {
    public static int findEquilibrium(int arr[]) {
        // code here
        /*                 i
            arr[] = [1, 2, 0, 3]
            sum = 3
            ls = 3

            Tc = O(n) SC = O(1)
        */
        int rs = 0;
        for(int num : arr) rs += num;
        int ls = 0;
        for(int i = 0; i<arr.length; i++){
            rs -= arr[i];
            if(rs == ls) return i;
            ls += arr[i];
        }
        return -1;
    }
}
