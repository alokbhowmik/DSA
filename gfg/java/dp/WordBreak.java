package dp;
import java.util.*;
/*
*Problem Name : Word Break
*
*Problem Link : https://www.geeksforgeeks.org/problems/word-break1352/1
*
*Problem Statement : 
*
* You are given a string s and a list dictionary[] of words. Your task is to determine whether the string s can be formed by concatenating one or more words from the dictionary[].

Note: From dictionary[], any word can be taken any number of times and in any order.

Examples :

Input: s = "ilike", dictionary[] = ["i", "like", "gfg"]
Output: true
Explanation: s can be breakdown as "i like".
Input: s = "ilikegfg", dictionary = ["i", "like", "man", "india", "gfg"]
Output: true
Explanation: s can be breakdown as "i like gfg".
Input: s = "ilikemangoes", dictionary = ["i", "like", "man", "india", "gfg"]
Output: false
Explanation: s cannot be formed using dictionary[] words.
Constraints:
1 ≤ s.size() ≤ 3000
1 ≤ dictionary.size() ≤ 1000
1 ≤ dictionary[i].size() ≤ 100
* 
* Approach 1 
*--------------
*TC = O(n * m) SC = O(n) m = max(dictiionary words length)
*/
public class WordBreak {
    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    class Trie{
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        public void add(String word){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                curr.children.putIfAbsent(ch, new TrieNode());
                curr = curr.children.get(ch);
            }
            curr.isEnd = true;
        }

        public boolean search(String word){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                if(!curr.children.containsKey(ch)) break;
                curr = curr.children.get(ch);
            }
            return curr.isEnd;
        }
    }

    private Trie trie;
    Boolean dp[];
    public int wordBreak(String s, String[] dictionary) {
        // code here
        trie = new Trie();

        for(String word : dictionary){
            trie.add(word);
        }
        dp = new Boolean[s.length() + 1];
        return canBreak(0, s) ? 1 : 0 ;
    }

    private boolean canBreak(int start, String s){
        if(start == s.length()) return true;
        if(dp[start] != null) return dp[start];
        TrieNode node = trie.root;
        for(int i = start; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!node.children.containsKey(ch)) break;
            node = node.children.get(ch);
            if(node.isEnd && canBreak(i + 1, s)){
                return dp[start] =  true;
            }
        }
        return dp[start] =  false;
    }
}