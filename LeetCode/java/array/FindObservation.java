package LeetCode.java.array;

/**
 * 
 * Problem Name : Find Missing Observations 2028
 * Problem Link : https://leetcode.com/problems/find-missing-observations/description/?envType=daily-question&envId=2024-09-05
 * 
 * Problem Statement 
 * =========================
 * 
 * You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing, and you only have the observations of m rolls. Fortunately, you have also calculated the average value of the n + m rolls.

You are given an integer array rolls of length m where rolls[i] is the value of the ith observation. You are also given the two integers mean and n.

Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean. If there are multiple valid answers, return any of them. If no such array exists, return an empty array.

The average value of a set of k numbers is the sum of the numbers divided by k.

Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.

 

Example 1:

Input: rolls = [3,2,4,3], mean = 4, n = 2
Output: [6,6]
Explanation: The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.
Example 2:

Input: rolls = [1,5,6], mean = 3, n = 4
Output: [2,3,2,2]
Explanation: The mean of all n + m rolls is (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3.
Example 3:

Input: rolls = [1,2,3,4], mean = 6, n = 4
Output: []
Explanation: It is impossible for the mean to be 6 no matter what the 4 missing rolls are.
 

Constraints:

m == rolls.length
1 <= n, m <= 10^5
1 <= rolls[i], mean <= 6

Time Complexity : O(n)
Space Complexity : O(1)
 */
public class FindObservation {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int ans[] = new int[n];
        int m = rolls.length;
        int sum = 0;
        for(int roll: rolls){
            sum += roll;
        }
        int target =( mean * (n + m )) - sum;
        if(target < 0 || target > 6*n) return new int[0];
        while(target > 0){
            int d = target / n;
            if(d > 6 || d <= 0){
                return new int[0];
            }
            ans[n-1] = d;
            n--;
            target -= d;
        }
        return ans;
    }   
}