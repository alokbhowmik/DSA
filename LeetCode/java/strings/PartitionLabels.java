package strings;

import java.util.ArrayList;
import java.util.List;

/*
*Problem Name : Partition Labels
*
*Problem Link : https://leetcode.com/problems/partition-labels/description/?envType=daily-question&envId=2025-03-30
*
*Problem Statement : 
*
* You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.



Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]


Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*
* Approach 1  : Two Pointer
*--------------
*TC = O(n) SC = O(1)
*/
public class PartitionLabels{
    public List<Integer> partitionLabels(String s) {
        int limit[] = new int[26];
        for(int i = 0; i<s.length(); i++){
            limit[s.charAt(i) - 'a'] = i ;
        }

        int start = 0, end = limit[s.charAt(0) - 'a'];
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i< s.length(); i++){
            if(i > end){
                res.add(end - start + 1);
                start = i;
            }
            end = Math.max(end, limit[s.charAt(i) - 'a']);
        }
        res.add(end - start + 1);
        return res;
    }
}