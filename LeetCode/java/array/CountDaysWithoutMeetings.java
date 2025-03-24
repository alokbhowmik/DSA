package array;

import java.util.Arrays;

/*
*Problem Name : Count Days Without Meetings
*
*Problem Link : https://leetcode.com/problems/count-days-without-meetings/description/?envType=daily-question&envId=2025-03-24
*
*Problem Statement : 
*
* You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

Return the count of days when the employee is available for work but no meetings are scheduled.

Note: The meetings may overlap.



Example 1:

Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

Output: 2

Explanation:

There is no meeting scheduled on the 4th and 8th days.

Example 2:

Input: days = 5, meetings = [[2,4],[1,3]]

Output: 1

Explanation:

There is no meeting scheduled on the 5th day.

Example 3:

Input: days = 6, meetings = [[1,6]]

Output: 0

Explanation:

Meetings are scheduled for all working days.



Constraints:

1 <= days <= 10^9
1 <= meetings.length <= 10^5
meetings[i].length == 2
1 <= meetings[i][0] <= meetings[i][1] <= days
* Approach 1 
*--------------
*TC = O(n* log(n) ) SC = O(1)
*/
public class CountDaysWithoutMeetings{
    public int countDays(int days, int[][] meetings) {
        //boolean[] available = new boolean[days + 1];
        Arrays.sort(meetings, (a, b)->a[0] - b[0]);
        int ans = 0, i = 0;
        int currDay = 1;
        while(currDay <= days && i < meetings.length){
            if(currDay >= meetings[i][0]){
                currDay =Math.max(currDay, meetings[i][1] + 1);
                i++;
                continue;
            }else{
                ans += (meetings[i][0] - currDay);
                currDay = Math.max(currDay, meetings[i][0]);
            }
        }
        if(currDay <= days) ans += (days - currDay + 1);
        return ans;
    }
}