package array;
/*
* Problem Name : Trapping Rain Water
*
* Problem Link : https://www.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
*
* Problem Statement
*
* Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.

Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0 2]
Output: 10
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.
Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides.
Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
Output: 9
Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.
Constraints:
1 < arr.size() < 10^5
0 < arr[i] < 10^3
*
*
* */
public class TappingRainWatter {

    public int maxWater(int arr[]) {
        // code here
        //  3, 0, 1, 0, 4, 0 2
        //  4  4  4  4  4  2 2

        //  3  3  3  3  4  4 2

        //  3 + 2 + 3 + 0 + 2 + 0 = 10
        // Approach 1 : TC = O(n) SC = O(n)
//        int n = arr.length;
//        int[] left = new int[n];
//        left[0] = arr[0];
//        for (int i = 1; i < n; i++) {
//            left[i] = Math.max(left[i - 1], arr[i]);
//        }
//        int rightMax = arr[n - 1];
//        int sum = 0;
//        for (int i = n - 2; i > 0; i--) {
//            rightMax = Math.max(rightMax, arr[i]);
//            sum += Math.min(rightMax, left[i]) - arr[i];
//        }
//        return sum;
        // Approach 2 : TC = O(n) SC = O(1)
        int l = 1, r = arr.length - 2 ;
        int sum = 0;
        int leftMax = arr[0], rightMax = arr[arr.length - 1];

        while(l <= r){
            leftMax  = Math.max(leftMax, arr[l]);
            rightMax = Math.max(rightMax, arr[r]);
            if(leftMax > rightMax){
                sum += rightMax - arr[r];
                r--;
            }else{
                sum += leftMax - arr[l];
                l++;
            }
        }
        return sum;
    }
}
