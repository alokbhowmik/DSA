package array;

import java.util.HashMap;
import java.util.Map;

/*
*Problem Name : Balancing Consonants and Vowels Ratio
*
*Problem Link : https://www.geeksforgeeks.org/problems/balancing-consonants-and-vowels-ratio/1
*
*Problem Statement : 
*
* You are given an array of strings arr[], where each arr[i] consists of lowercase english alphabets. You need to find the number of balanced strings in arr[] which can be formed by concatinating one or more contiguous strings of arr[].
A balanced string contains the equal number of vowels and consonants.

Examples:

Input: arr[] = ["aeio", "aa", "bc", "ot", "cdbd"]
Output: 4
Explanation: arr[0..4], arr[1..2], arr[1..3], arr[3..3] are the balanced substrings with equal consonants and vowels.
Input: arr[] = ["ab", "be"]
Output: 3
Explanation: arr[0..0], arr[0..1], arr[1..1] are the balanced substrings with equal consonants and vowels.
Input: arr[] = ["tz", "gfg", "ae"]
Output: 0
Explanation: There is no such balanced substring present in arr[] with equal consonants and vowels.
Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i].size() ≤ 10^5
Total number of lowercase english characters in arr[] is lesser than 10^5.
* Approach 1 
*--------------
*TC = O(n*k) SC = O(n)
*/
public class BalancingConsonantsAndVowelsRatio{
    public int countBalanced(String[] arr) {
        // code here
        /*
         ["aeio", "aa", "bc", "ot", "cdbd"]
           4       2     0     1      0
           0       0     2     1      4
           4       6     4     4      0

           ans = 1 + 2 + 1
           0 = 1
           4 = 2
           6 = 1

        */
        int n = arr.length ;
        int[] balance = new int[n] ;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int vowel= 0, consonent = 0;
            for(char ch : arr[i].toCharArray()){
                if(isVowel(ch)) vowel++;
                else consonent++;
            }
            balance[i] = vowel - consonent ;
        }
        map.put(0, 1)  ;
        int sum = 0, res = 0;
        for(int num : balance){
            sum += num ;
            res += map.getOrDefault(sum, 0) ;
            map.put(sum, map.getOrDefault(sum, 0) + 1) ;
        }
        return res ;
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ;
    }
}