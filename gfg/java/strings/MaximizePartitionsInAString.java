package strings;

/*
*Problem Name : Maximize partitions in a String
*
*Problem Link : https://www.geeksforgeeks.org/problems/maximize-partitions-in-a-string/1
*
*Problem Statement : 
*
* Given a string s of lowercase English alphabets, your task is to return the maximum number of substrings formed, after possible partitions (probably zero) of s such that no two substrings have a common character.

Examples:

Input: s = "acbbcc"
Output: 2
Explanation: "a" and "cbbcc" are two substrings that do not share any characters between them.
Input: s = "ababcbacadefegdehijhklij"
Output: 3
Explanation: Partitioning at the index 8 and at 15 produces three substrings: “ababcbaca”, “defegde”, and “hijhklij” such that none of them have a common character. So, the maximum number of substrings formed is 3.
Input: s = "aaa"
Output: 1
Explanation: Since the string consists of same characters, no further partition can be performed. Hence, the number of substring (here the whole string is considered as the substring) is 1.
Constraints:
1 ≤ s.size() ≤ 10^5
'a' ≤ s[i] ≤ 'z'
* Approach 1 
*--------------
*TC = O(n) SC = O(1)
*/
public class MaximizePartitionsInAString{
    public int maxPartitions(String s) {
        // code here
        int limit[] = new int[26];
        for(int i = 0; i<s.length(); i++){
            limit[s.charAt(i) - 'a'] = i ;
        }

        int start = 0, end = limit[s.charAt(0) - 'a'];
        int res = 0;

        for(int i = 0; i< s.length(); i++){
            if(i > end){
                res++;
                start = i;
            }
            end = Math.max(end, limit[s.charAt(i) - 'a']);
        }
        res++;
        return res;
    }
}