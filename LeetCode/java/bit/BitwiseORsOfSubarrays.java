package bit;

import java.util.HashSet;
import java.util.Set;

/*
*Problem Name : Bitwise ORs of Subarrays
*
*Problem Link : https://leetcode.com/problems/bitwise-ors-of-subarrays/description/?envType=daily-question&envId=2025-07-31
*
*Problem Statement : 
*
* Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.

The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: arr = [0]
Output: 1
Explanation: There is only one possible result: 0.
Example 2:

Input: arr = [1,1,2]
Output: 3
Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values, so the answer is 3.
Example 3:

Input: arr = [1,2,4]
Output: 6
Explanation: The possible results are 1, 2, 3, 4, 6, and 7.


Constraints:

1 <= arr.length <= 5 * 10^4
0 <= arr[i] <= 10^9
* Approach 1 
*--------------
*TC = O(nlog(k)) SC = O(k)
*/
public class BitwiseORsOfSubarrays{
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        curr.add(arr[0]) ;
        for(int num : arr){
            Set<Integer> curr2 = new HashSet<>();
            curr2.add(num);
            for(int num2 : curr){
                curr2.add(num2 | num) ;
            } 
            curr = curr2;
            ans.addAll(curr) ;
        }
        return ans.size();
    }
}