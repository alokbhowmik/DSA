package strings;

import java.util.*;

/*
*Problem Name : Longest String Chain
*
*Problem Link : https://www.geeksforgeeks.org/problems/longest-string-chain/1
*
*Problem Statement : 
*
* You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB. For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k = 1.

Return the length of the longest possible word chain with words chosen from the given list of words in any order.

Examples:

Input: words[] = ["ba", "b", "a", "bca", "bda", "bdca"]
Output: 4
Explanation: One of the longest word chains is ["a", "ba", "bda", "bdca"].

Input: words[] = ["abc", "a", "ab"]
Output: 3
Explanation: The longest chain is {"a", "ab" "abc"}
Input: words[] = ["abcd", "dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
Constraint:
1 <= words.length <= 10^4
1 <= words[i].length <= 10
 words[i] only consists of lowercase English letters.
* Approach 1 
*--------------
*TC = O(n * log(n) + n * m^2) SC = O(n)
*/
public class LongestStringChain{
    public int longestStringChain(String words[]) {
        // code here
        Arrays.sort(words, Comparator.comparing(s->s.length()));
        int n = words.length;
        int[] dp = new int[n] ;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            String word = words[i];
            if(!map.containsKey(word.length())){
                map.put(word.length(), new ArrayList<>());
            }
            map.get(word.length()).add(i);
        }
        int max = 1;
        Arrays.fill(dp, 1);

        for(int i = 0; i<n; i++){
            if(map.containsKey(words[i].length() - 1)){
                for(int prev : map.get(words[i].length() - 1)){
                    if(check(words[i], words[prev]) && 1 + dp[prev] > dp[i]){
                        dp[i] = dp[prev] + 1;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private boolean check(String s1, String s2){
        if(s1.length() != s2.length() + 1) return false;
        int f = 0, s = 0;
        while(f < s1.length()){
            if(s < s2.length() && s1.charAt(f) == s2.charAt(s)){
                s++;
                f++;
            }else{
                f++;
            }
        }
        return (f == s1.length() && s == s2.length()) ;
    }
}