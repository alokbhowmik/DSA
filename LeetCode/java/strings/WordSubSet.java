package strings;

import java.util.*;

/*
*
* Problem Name : Word Subsets
* Problem Link : https://leetcode.com/problems/word-subsets/description/
*
* Problem Statement
*
* You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.



Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]


Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.
* */
public class WordSubSet {

    public List<String> wordSubsets(String[] words1, String[] words2) {

        // TC = O(M + N ) SC = O(1)
        int[] freq2 = new int[26];
        List<String> res = new ArrayList<>();
        for(String word : words2){
            int[] temp = new int[26];
            for(char ch : word.toCharArray()){
                temp[ch - 'a']++;
            }
            for(int i = 0; i<26; i++){
                freq2[i] = Math.max(freq2[i], temp[i]);
            }
        }

        search : for(String word : words1){
            int[] freq1 = new int[26];
            for(char ch : word.toCharArray()){
                freq1[ch - 'a']++;
            }
            for(int i = 0; i<26; i++){
                if(freq2[i] > freq1[i]){
                    continue search;
                }
            }
            res.add(word);
        }
        return res;
    }
}
