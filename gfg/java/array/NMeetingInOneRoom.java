package gfg.java.array;

import java.util.Arrays;

/**
 * 
 * Problem Name : N meetings in one room
 * Problem Link : https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 * 
 * Problem Statement
 * -------------------
 * You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time. 

Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Examples :

Input: n = 6, start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)
Input: n = 3, start[] = [10, 12, 20], end[] = [20, 25, 30]
Output: 1
Explanation: Only one meetings can be held with given start and end timings.
Expected Time Complexity: O(n*logn)
Expected Auxilliary Space: O(n)

Constraints:
1 ≤ n ≤ 105
0 ≤ start[i] < end[i] ≤ 106

Time Complexity = O(n*log(n))
Space Complexity = O(n) due to paris array
 */
public class NMeetingInOneRoom {
    class Pair implements Comparable<Pair>{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Pair p){
            return this.end - p.end;
        }
    }
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        Pair[] pairs = new Pair[n];
        for(int i=0; i<n; i++){
            pairs[i] = new Pair(start[i], end[i]);
        }
        
        Arrays.sort(pairs);
        int cnt = 1;
        Pair currTimeRange = pairs[0];
        for(int i=1; i<n; i++){
            if(currTimeRange.end < pairs[i].start ){
                cnt++;
                currTimeRange = pairs[i];
            }
        }
        return cnt;
    }
}
