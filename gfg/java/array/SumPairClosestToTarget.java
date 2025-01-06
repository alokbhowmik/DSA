package array;
/*
*
* Problem Name : Sum Pair closest to target
* Problem Link : https://www.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-x1124/1
*
* Problem Statement
*
* Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

Examples:

Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: As 5 + 20 = 25 is closest to 25.
Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target.
Input: arr[] = [10], target = 10
Output: []
Explanation: As the input array has only 1 element, return an empty array.
Constraints:
1 <= arr.size() <= 2*10^5
0 <= target<= 2*10^5
0 <= arr[i] <= 10^5
*
*
* */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPairClosestToTarget {
    public List<Integer> sumClosest(int[] arr, int target) {
        // TC = O(nlog(n)) SC = O(1)

        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        if(n < 2) return res;
        Arrays.sort(arr);
        int l = 0, r = n - 1;
        int minAbs = Integer.MIN_VALUE, maxDiff = -1;
        int num1 = -1, num2 = -1;
        while (l < r){
            int sum = arr[l] + arr[r];
            int currAbs = Math.abs(arr[r] - arr[l]);
            if(currAbs < minAbs || (currAbs == minAbs && Math.abs(arr[r] - arr[l]) > maxDiff)){
                minAbs = currAbs;
                num1 = arr[l];
                num2 = arr[r];
                maxDiff = Math.abs(arr[r] - arr[l]);
            }
            if(target <= sum) l++;
            else r--;
        }
        res.add(num1);
        res.add(num2);
        return res;
    }
}
