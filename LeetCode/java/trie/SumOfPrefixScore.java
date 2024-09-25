package LeetCode.java.trie;

/**
 * 
 * Problem Name : Sum of Prefix Scores of Strings
 * Problem Link : https://leetcode.com/problems/sum-of-prefix-scores-of-strings/description/
 * Problem Statement 
 * ===================
 * 
 * You are given an array words of size n consisting of non-empty strings.

We define the score of a string word as the number of strings words[i] such that word is a prefix of words[i].

For example, if words = ["a", "ab", "abc", "cab"], then the score of "ab" is 2, since "ab" is a prefix of both "ab" and "abc".
Return an array answer of size n where answer[i] is the sum of scores of every non-empty prefix of words[i].

Note that a string is considered as a prefix of itself.

 

Example 1:

Input: words = ["abc","ab","bc","b"]
Output: [5,4,3,2]
Explanation: The answer for each string is the following:
- "abc" has 3 prefixes: "a", "ab", and "abc".
- There are 2 strings with the prefix "a", 2 strings with the prefix "ab", and 1 string with the prefix "abc".
The total is answer[0] = 2 + 2 + 1 = 5.
- "ab" has 2 prefixes: "a" and "ab".
- There are 2 strings with the prefix "a", and 2 strings with the prefix "ab".
The total is answer[1] = 2 + 2 = 4.
- "bc" has 2 prefixes: "b" and "bc".
- There are 2 strings with the prefix "b", and 1 string with the prefix "bc".
The total is answer[2] = 2 + 1 = 3.
- "b" has 1 prefix: "b".
- There are 2 strings with the prefix "b".
The total is answer[3] = 2.
Example 2:

Input: words = ["abcd"]
Output: [4]
Explanation:
"abcd" has 4 prefixes: "a", "ab", "abc", and "abcd".
Each prefix has a score of one, so the total is answer[0] = 1 + 1 + 1 + 1 = 4.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists of lowercase English letters.

Time Complexity : O(N*K)
Space Complexity : O(N) due to Trie DSA 
 */
public class SumOfPrefixScore {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int freq = 0;
    }
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }

        void buildTrie(String word, TrieNode root){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                int idx = ch - 'a';
                if(curr.children[idx] == null)
                    curr.children[idx] = new TrieNode();
                curr = curr.children[idx];
                curr.freq++;
                // System.out.println(ch + " :" + curr.freq);
            }
        }

        int calculateScore(String word, TrieNode root){
            // System.out.println(word);
            TrieNode curr = root;
            int score = 0;
            for(char ch : word.toCharArray()){
                curr = curr.children[ch - 'a'];
                // System.out.print(curr + " : ");
                if(curr == null ) break;
                score += curr.freq;
            }
            return score;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for(String word: words){
            trie.buildTrie(word, trie.root);
        }
        int n = words.length;
        int scores[] = new int[n];
        for(int i=0; i<n; i++){
            scores[i] = trie.calculateScore(words[i], trie.root);
        }
        return scores;
    }
}
