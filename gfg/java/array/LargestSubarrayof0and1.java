package array;
import java.util.*;

/*
*
* Problem Name  : Largest subarray of 0's and 1's
*
* Problem Link : https://www.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
*
* Problem Statement
*
* Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.

Examples:

Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
Output: 6
Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.
Input: arr[] = [0, 0, 1, 1, 0]
Output: 4
Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.
Input: arr[] = [0]
Output: 0
Explnation: There is no subarray with an equal number of 0s and 1s.
Constraints:
1 <= arr.size() <= 10^5
0 <= arr[i] <= 1
 * */
public class LargestSubarrayof0and1 {
    public int maxLen(int[] arr) {
        // Your code here
        /*
                            i
        [1,-1, 1, 1, 1, -1, -1]
         0  1  2  3  4  5   6
        sum = 1
        ans = 6
        {1 : 0, 2: 3, 3 : 4}
        */
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        int sum = 0, max = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
            if(sum == 0){
                max = i + 1;
                continue;
            }
            if(map.containsKey(sum)){
                max = Math.max(max, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return max;
    }
}
