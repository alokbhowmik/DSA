package LeetCode.java.slidingWindow;

/**
 * 
 * 
 * Problem Name : Permutation in String
 * Problem Link : https://leetcode.com/problems/permutation-in-string/description/
 * 
*Problem Statement
*
 * Given two strings s1 and s2, return true if s2 contains a 
permutation
 of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.

Time Complexity : O(n)
Space Complexity : O(1)
 */

public class PermutationInString {
    private boolean found(int freq1[], int freq2[]){
        for(int i=0;i <26; i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(char ch : s1.toCharArray()){
            freq1[ch - 'a']++;
        }
        int i = 0, j= 0;
        while(i < s2.length()){
            freq2[s2.charAt(i) - 'a']++;
            while(j < s2.length() && i - j + 1 >= s1.length()){
                if(found(freq1, freq2)) return true;
                freq2[s2.charAt(j) - 'a']--;
                j++;
            }
            i++;
        }
        return false;
    }
}
