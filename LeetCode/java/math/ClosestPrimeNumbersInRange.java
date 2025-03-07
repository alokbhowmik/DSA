/*
*Problem Name : Closest Prime Numbers in Range
*
*Problem Link : https://leetcode.com/problems/closest-prime-numbers-in-range/description/
*
*Problem Statement : 
*
* Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].



Example 1:

Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.
Example 2:

Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.


Constraints:

1 <= left <= right <= 10^6
* Approach 1 
*--------------
*TC = O(n * sqrt(n) ) SC = O(1)
*/
public class ClosestPrimeNumbersInRange{
    public int[] closestPrimes(int left, int right) {
        int[] ans = new int[]{-1, -1};

        int first = -1, second = -1;
        int minDiff = Integer.MAX_VALUE;
        for(int num = left; num <= right; num++){
            if(isPrime(num)){
                first = second;
                second = num;
                if(first != -1 && second - first < minDiff){
                    minDiff = second - first;
                    ans[0] = first;
                    ans[1] = second;
                }
                if(minDiff == 1) break;
            }
        }
        return ans;
    }

    private boolean isPrime(int num){
        if(num == 1) return false;
        if(num == 2 || num == 3) return true;
        for(int i = 2; i<= (int)Math.sqrt(num); i++){
            if(num %i == 0) return false;
        }
        return true;
    }
}