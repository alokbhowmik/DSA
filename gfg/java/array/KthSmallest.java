package gfg.java.array;
/*
 * 
 * Problem Name : Kth Smallest
 * Problem Link : https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
 * 
 * Problem Statement
 * 
 * Given an array arr[] and an integer k where k is smaller than the size of the array, the task is to find the kth smallest element in the given array. It is given that all array elements are distinct.

Follow up: Don't solve it using the inbuilt sort function.

Examples :

Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
Output:  7
Explanation: 3rd smallest element in the given array is 7.
Input: arr[] = [7, 10, 4, 20, 15], k = 4 
Output:  15
Explanation: 4th smallest element in the given array is 15.
Expected Time Complexity: O(n+(max_element) )
Expected Auxiliary Space: O(max_element)
Constraints:
1 <= arr.size <= 10^6
1<= arr[i] <= 10^6
1 <= k <= n
 */

public class KthSmallest {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int max = 0;
        for(int num: arr){
            max = Math.max(max, num);
        }
        int freq[] = new int[max + 1];
        for(int num: arr){
            freq[num] = 1;
        }
        for(int i=0; i<=max; i++){
            if(freq[i] == 1){
                k--;
            }
            if(k == 0) return i;
        }
        return -1;
    }
}
