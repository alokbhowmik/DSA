package array;
import java.util.*;

/*
*Problem Name : Majority Element
*
*Problem Link : https://www.geeksforgeeks.org/problems/majority-element-1587115620/1?_gl=1*1pi03jp*_up*MQ..*_gs*MQ..&gclid=CjwKCAjwnei0BhB-EiwAA2xuBvXs4kprlF1EQOn1w3UUNNyKFP5ljE_fIf9xXO8P0Jy_hdGt_yuaYRoClxoQAvD_BwE
*
*Problem Statement : 
*
* Given an array arr[]. Find the majority element in the array. If no majority element exists, return -1.

Note: A majority element in an array is an element that appears strictly more than arr.size()/2 times in the array.

Examples:

Input: arr[] = [1, 1, 2, 1, 3, 5, 1]
Output: 1
Explanation: Since, 1 is present more than 7/2 times, so it is the majority element.
Input: arr[] = [7]
Output: 7
Explanation: Since, 7 is single element and present more than 1/2 times, so it is the majority element.
Input: arr[] = [2, 13]
Output: -1
Explanation: Since, no element is present more than 2/2 times, so there is no majority element.
Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^5
*
* Approach 1  : HashMap
*--------------
*TC = O(n) SC = O(n)
*/
public class MajorityElement{
    static int majorityElement(int arr[]) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int freq = arr.length / 2;
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > freq) return num;
        }
        return -1;

    }
}