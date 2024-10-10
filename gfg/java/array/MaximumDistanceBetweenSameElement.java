package gfg.java.array;

import java.util.*;

/**
 * 
 * Problem Name : Max distance between same elements
 * Problem Link : https://www.geeksforgeeks.org/problems/max-distance-between-same-elements/1
 * 
 * Problem Statement 
 * 
 * Given an array arr[] with repeated elements, the task is to find the maximum distance between two occurrences of an element.

Note: You may assume that every input array has repetitions.

Examples:

Input: arr = [1, 1, 2, 2, 2, 1]
Output: 5
Explanation: distance for 1 is: 5-0 = 5, distance for 2 is : 4-2 = 2, So max distance is 5.
Input: arr = [3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2]
Output: 10
Explanation: maximum distance for 2 is 11-1 = 10, maximum distance for 1 is 4-2 = 2 ,maximum distance for 4 is 10-5 = 5, So max distance is 10.
Expected Time Complexity :  O(n)
Expected Auxilliary Space : O(n)

Constraints:
1 <= arr.size() <= 10^6
1 <= arr[i] <= 10^9
 */
public class MaximumDistanceBetweenSameElement {
    public int maxDistance(int[] arr) {
        // Code here
        Map<Integer, Integer> map = new HashMap<>();
        int maxDist = 0;
        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i]) == null){
                map.put(arr[i], i);
            }else{
                maxDist = Math.max(maxDist, i - map.get(arr[i]));
            }
        }
        return maxDist;
    }
}
