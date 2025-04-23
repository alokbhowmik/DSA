import java.util.*;

/*
*Problem Name : Count Largest Group
*
*Problem Link : https://leetcode.com/problems/count-largest-group/description/?envType=daily-question&envId=2025-04-23
*
*Problem Statement : 
*
* You are given an integer n.

Each number from 1 to n is grouped according to the sum of its digits.

Return the number of groups that have the largest size.



Example 1:

Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
There are 4 groups with largest size.
Example 2:

Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.


Constraints:

1 <= n <= 10^4
*
* Approach 1 
*--------------
*TC = O(nlog(n)) SC = O(n)
*/
public class CountLargestGroup{
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, count = 0;
        for(int num = 1; num <= n; num++){
            int sum = digitSum(num);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // max = Math.max(max, map.get(sum));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max) count++;
        }
        return count;
    }

    private int digitSum(int num ){
        int sum = 0;
        while(num > 0){
            sum += num % 10 ;
            num /= 10;
        }
        return sum;
    }
}