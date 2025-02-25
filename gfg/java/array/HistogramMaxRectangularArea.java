package array;

import java.util.Stack;

/*
*Problem Name : Histogram Max Rectangular Area
*
*Problem Link : https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
*
*Problem Statement :
*
* You are given a histogram represented by an array arr, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

Examples:

Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 Largest-Rectangular-Area-in-a-Histogram
Output: 100
Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.
Input: arr[] = [3, 5, 1, 7, 5, 9]
Output: 15
Explanation:  We get the maximum by picking bars 7, 5 and 9. The area is computed (smallest height) * (no. of the picked bars) = 5 * 3 = 15.
Input: arr[] = [3]
Output: 3
Explanation: In this example the largest area would be 3 of height 3 and width 1.
Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^4
*
* Approach 1 
*--------------
*TC = O(n) SC = O(n)
*/
public class HistogramMaxRectangularArea{
    public static int getMaxArea(int arr[]) {
        // your code here
        int[] next = nextMinimum(arr);
        int[] prev = prevMinimum(arr);
        int area = 0;
        for(int i =0; i<arr.length; i++){
            int width = next[i] - prev[i] - 1;
            int height = arr[i];
            area = Math.max(area, width * height);
        }
        return area;
    }

    private static int[] nextMinimum(int arr[]){
        int n = arr.length;
        int[] next = new int[n];
        // next[n] = n;
        Stack<Integer> st = new Stack<>();
        st.push(n);
        for(int i = n-1; i>=0; i--){
            while(st.size() > 1 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            next[i] = st.peek();
            st.push(i);
        }
        return next;
    }

    private static int[] prevMinimum(int arr[]){
        int n = arr.length;
        int[] prev = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = 0; i<n; i++){
            while(st.size() > 1 && arr[st.peek()] > arr[i]) st.pop();
            prev[i] = st.peek();
            st.push(i);
        }
        return prev;
    }
}