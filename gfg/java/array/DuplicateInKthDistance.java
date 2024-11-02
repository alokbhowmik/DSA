package gfg.java.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem Name : Duplicate In Kth Distance
 * Problem Link : https://www.geeksforgeeks.org/problems/kth-distance3757/1
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * 
 * 
 */
public class DuplicateInKthDistance {
     public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i]) && i - map.get(arr[i]) <= k) return true;
            map.put(arr[i], i);
        }
        return false;
    }
}
