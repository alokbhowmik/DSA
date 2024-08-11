package gfg.java.array;

import java.util.Arrays;

/**
 * 
 * Problem Name : Job Sequencing Problem
 * Problem Link : https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 * 
 * Problem Statement : 
 * Given a set of n jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with a job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time on or before which job needs to be completed to earn the profit.

Examples :

Input: Jobs = [[1,4,20],[2,1,1],[3,1,40],[4,1,30]]
Output: 2 60
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
Input: Jobs = [[1,2,100],[2,1,19],[3,2,27],[4,1,25],[5,1,15]]
Output: 2 127
Explanation: 2 jobs can be done with maximum profit of 127 (100+27).
Expected Time Complexity: O(nlogn)
Expected Auxilliary Space: O(n)

Constraints:
1 <= n <= 105
1 <= Deadline,id <= n
1 <= Profit <= 500

Time Complexity : O(nlogn + n*n + n) 
Space Complexity : O(n)
 */
public class JobSequencingProblem {
    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
    // Approach 1
     int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a, b)-> b.profit - a.profit);// sort in decending order accoding to the profit
        int maxDeadLine = 0;
        for(Job j : arr){
            maxDeadLine = Math.max(maxDeadLine, j.deadline);
        }
        int jobCnt = 0, totalProfit = 0;
        int profits[] = new int[maxDeadLine];
        for(Job j : arr){
            int d = j.deadline - 1;
            while(d >= 0 && profits[d] != 0){
                d--;
            }
            if(d >= 0)
                profits[d] = j.profit;
        }
        for(int p : profits){
            totalProfit += p;
            if(p > 0) jobCnt++;
        }
        return new int[]{jobCnt, totalProfit};   
    }
}
