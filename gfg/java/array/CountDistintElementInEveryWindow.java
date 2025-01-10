package array;

import java.util.*;
/*
*
* Problem Name : Count distinct elements in every window
* Problem Link : https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
*
* Problem Statement
*
*
* Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Examples:

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3.
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
Input: arr[] = [4, 1, 1], k = 2
Output: [2, 1]
Explanation: Window 1 of size k = 2 is 4 1. Number of distinct elements in this window are 2.
Window 2 of size k = 2 is 1 1. Number of distinct elements in this window is 1.
Input: arr[] = [1, 1, 1, 1, 1], k = 3
Output: [1, 1, 1]
Constraints:
1 <= k <= arr.size() <= 10^5
1 <= arr[i] <= 10^5
* */
public class CountDistintElementInEveryWindow {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        //             i
        // 1, 2, 1, 3, 4, 2, 3], k = 4
        //                     j
        // {3: 1, 4 : 1, 2 : 1}
        // ans = [3, 4, 4, 3]

        int i = 0, j = 0, n = arr.length ;
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        while(j < n){
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            if(j - i + 1 == k){
                res.add(map.size());
                map.put(arr[i], map.get(arr[i]) - 1);
                if(map.get(arr[i]) == 0) map.remove(arr[i]);
                i++;
            }
            j++;
        }
        return res;
    }
}
