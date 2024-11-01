package gfg.java.array;

import java.util.Arrays;

/**
 * 
 * Problem Name : Swap and Maximize
 * Problem Link : https://www.geeksforgeeks.org/problems/swap-and-maximize5859/1
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class SwapAndMaximize {
    public long maxSum(Long[] arr) {
        // code here
        Arrays.sort(arr);
        int i=0, j = arr.length - 1;
        long sum = 0;
        while(i <= j){
            sum += arr[j] * 2;
            sum -= arr[i] * 2;
            i++;
            j--;
        }
        return sum;
    }
}
