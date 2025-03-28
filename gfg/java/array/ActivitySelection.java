package array;

import java.util.Arrays;

/*
*Problem Name : Activity Selection
*
*Problem Link : https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1
*
*Problem Statement :
*
* You are given a set of activities, each with a start time and a finish time, represented by the arrays start[] and finish[], respectively. A single person can perform only one activity at a time, meaning no two activities can overlap. Your task is to determine the maximum number of activities that a person can complete in a day.

Examples:

Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: A person can perform at most four activities. The maximum set of activities that can be executed is {0, 1, 3, 4}
Input: start[] = [10, 12, 20], finish[] = [20, 25, 30]
Output: 1
Explanation: A person can perform at most one activity.
Input: start[] = [1, 3, 2, 5], finish[] = [2, 4, 3, 6]
Output: 3
Explanation: A person can perform activities 0, 1 and 3.
Constraints:
1 ≤ start.size() = finish.size() ≤ 2*10^5
1 ≤ start[i] ≤ finish[i] ≤ 10^9
*
* Approach 1 
*--------------
*TC = O(n) SC = O(n)
*/
public class ActivitySelection{
    public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n = start.length;
        int[][] pair = new int[n][2];
        for(int i = 0; i<n; i++){
            pair[i] = new int[]{start[i], finish[i]};
        }

        Arrays.sort(pair, (a, b)->a[1] - b[1]);

        int ans = 1;
        int end = pair[0][1];
        for(int i = 1; i < n; i++){
            if(pair[i][0] > end){
                ans++;
                end = pair[i][1];
            }
        }
        return ans;
    }
}