package strings;
/*
*
* Problem Name : Minimum Number of Operations to Move All Balls to Each Box
* Problem Link : https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/
*
* Problem Statement
*
* You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.

In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.

Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.

Each answer[i] is calculated considering the initial state of the boxes.



Example 1:

Input: boxes = "110"
Output: [1,1,3]
Explanation: The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
Example 2:

Input: boxes = "001011"
Output: [11,8,5,4,3,4]


Constraints:

n == boxes.length
1 <= n <= 2000
boxes[i] is either '0' or '1'.
*
* */
public class MinimumNoOfOperationToMoveEachBallToEachBox {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        /**
         * 11 8 5 4 3 4
         * one = 2
         * 0 0 1 0 1 1
         * 11 8 5 3 1 0
         *  0 0 0 1 2 4
         *
         */
        int[] ans = new int[n];
        // Approach 1 :  TC = O(n^2) SC = O(1)
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (boxes.charAt(j) == '1') {
//                    ans[i] += Math.abs(j - i);
//                }
//            }
//        }

        // Approach 2 : TC = O(n) SC = O(n)
        int[] left = new int[n];
        int[] right = new int[n];
        int one = boxes.charAt(0) == '1' ? 1 : 0;
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + one;
            if (boxes.charAt(i) == '1')
                one++;
        }
        right[n - 1] = 0;
        one = boxes.charAt(n - 1) == '1' ? 1 : 0;


        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + one;
            if (boxes.charAt(i) == '1')
                one++;
        }
        for (int i = 0; i < n; i++) {
            ans[i] = right[i] + left[i];
        }
        return ans;
    }
}
