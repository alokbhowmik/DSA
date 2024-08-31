package gfg.java.array;

import java.util.Stack;

/**
 * 
 * Problem Name : Maximum Difference
 * Problem Link : https://www.geeksforgeeks.org/problems/maximum-difference-1587115620/1
 * 
 * Problem Statement : 
 * 
 * Given an integer array arr of integers, the task is to find the maximum absolute difference between the nearest left smaller element and the nearest right smaller element of every element in array arr. If for any component of the arr, the nearest smaller element doesn't exist then consider it as 0.

Examples :

Input: arr = [2, 1, 8]
Output: 1
Explanation: left smaller array ls = [0, 0, 1], right smaller array rs = [1, 0, 0]. Maximum Diff of abs(ls[i] - rs[i]) = 1
Input: arr = [2, 4, 8, 7, 7, 9, 3]
Output: 4
Explanation: left smaller array ls = [0, 2, 4, 4, 4, 7, 2], right smaller rs = [0, 3, 7, 3, 3, 3, 0]. Maximum Diff of abs(ls[i] - rs[i]) = abs(7 - 3) = 4
Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
1 <= arr.size() <= 10^6
1<= arr[i] <=10^9

Time Complexity = O(n)
Space Complexity = O(n) // due to stack and ls
 */
public class MaximumDifference {
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        int ls[] = new int[n]; // store left smallest element at index i 
        ls[0] = 0;
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int i=1; i<n; i++){
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ls[i] = st.peek();
            }
            st.push(arr[i]);
        }
        st.clear();
        int ans = ls[n - 1];
        st.push(arr[n-1]);
        for(int i= n - 1; i>= 0; i--){
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans = Math.max(ans, ls[i]);    
            }else{
                ans = Math.max(ans, Math.abs(ls[i] - st.peek()));
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
