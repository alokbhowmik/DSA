import java.util.HashMap;
import java.util.Map;


/*
* Problem Name : Count Subarrays with given XOR
* Problem Link : https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
*
* Problem statement
* ------------------
*
* Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples:

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
Constraints:

1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤10^5
0 ≤ k ≤ 10^5
*
* */
public class CountSubArrayWithGivenXor {
    public long subarrayXor(int[] arr, int k) {
        // code here
        /*
            6=  0110
            2 = 0010
            ---------

         ans = 1
         TC = O(N) SC = O(N)
        */
        Map<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
            if (xor == k) ans++;

            int requireXor = xor ^ k;
            if (map.containsKey(requireXor)) {
                ans += map.get(requireXor);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return ans;
    }
}
