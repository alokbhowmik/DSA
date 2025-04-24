import  java.util.*;

/*
*Problem Name : Unique Number III
*
*Problem Link : https://www.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1
*
*Problem Statement : 
*
* Given an array of integers arr[] where, every element appears thrice except for one which occurs once.
Find that element which occurs once.

Examples:

Input: arr[] = [1, 10, 1, 1]
Output: 10
Explanation: 10 occurs once in the array while the other element 1 occurs thrice.
Input: arr[] = [3, 2, 1, 34, 34, 1, 2, 34, 2, 1]
Output: 3
Explanation: All elements except 3 occurs thrice in the array.
Constraints:
1 ≤ arr.size() ≤ 10^5
arr.size() % 3 = 1
-109 ≤ arr[i] ≤ 10^9
* Approach 1 
*--------------
*TC = O(n) SC = O(n)
*
* * Approach 2
*--------------
*TC = O(n) SC = O(1)
*/
public class UniqueNumberIII{
    public int getSingle(int[] arr) {
        // code here
//        Map<Integer, Integer> freq = new HashMap<>();
//        for(int num : arr){
//            freq.put(num, freq.getOrDefault(num, 0) + 1);
//        }
//
//        for(int num : arr){
//            if(freq.get(num) == 1) return num;
//        }
//        return -1;

        // Approach 2
        int res = 0;
        for(int i = 0; i<32; i++){
            int bitCount = 0;
            for(int num : arr){
                if((num & (1<< i))  != 0 ) {
                    bitCount++;
                }
            }
            if(bitCount % 3 != 0){
                res |= (1 << i);
            }
        }
        return res;
    }
}