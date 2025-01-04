package array;

/*
*
*  Problem Name : Count all triplets with given sum in sorted array
*  Problem Link : https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1
*
*  Problem Statement
*
* Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Examples:

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
Input: arr[] = [-2, 0, 1, 1, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1.
Constraints:
3 ≤ arr.size() ≤ 10^4
-10^5 ≤ arr[i], target ≤ 10^5
* */
public class CountOfTripleateOfGivenSum {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        // TC = O(N^2) S.C = O(1)
        int ans = 0;
        int n = arr.length ;
        for(int i = 0; i< n; i++){
            int j = i + 1, k = n - 1;
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target){
                    ans++;
                    int temp = j + 1;
                    while(temp < k && arr[temp] == arr[temp - 1]){
                        temp++; ans++;
                    }
                    k--;
                }else if(sum > target){
                    k--;
                }else j++;
            }
        }
        return ans;
    }
}
