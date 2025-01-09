package strings;
/*
*
* Problem Name : Counting Words With a Given Prefix
*
* Problem Link : https://leetcode.com/problems/counting-words-with-a-given-prefix/description/
*
* Problem Statement :
*
*You are given an array of strings words and a string pref.

Return the number of strings in words that contain pref as a prefix.

A prefix of a string s is any leading contiguous substring of s.



Example 1:

Input: words = ["pay","attention","practice","attend"], pref = "at"
Output: 2
Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
Example 2:

Input: words = ["leetcode","win","loops","success"], pref = "code"
Output: 0
Explanation: There are no strings that contain "code" as a prefix.


Constraints:

1 <= words.length <= 100
1 <= words[i].length, pref.length <= 100
words[i] and pref consist of lowercase English letters.
*
* */
public class CountWordsWithAGivenPrefix {

    class TrieNode{
        TrieNode links[] = new TrieNode[26];
        int count = 0;

        public boolean isContains(char ch){
            return links[ch - 'a'] != null;
        }

        public TrieNode next(char ch){
            return links[ch - 'a'];
        }

        public void add(char ch, TrieNode node){
            if(isContains(ch)) return ;
            links[ch - 'a'] = node;
        }

    }

    class Trie{
        private TrieNode root;

        Trie(){
            root = new TrieNode();
        }
        public void add(String word){
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                node.add(ch, new TrieNode());
                node = node.next(ch);
                node.count++;
            }
        }

        public int countPrefix(String word){
            TrieNode node = root;
            for(char ch : word.toCharArray()){
                if(!node.isContains(ch)) return 0;
                node = node.next(ch);
            }
            return node.count;
        }
    }

    public int prefixCount(String[] words, String pref) {
//        int count = 0;
//        // TC = O(n*k) SC = O(1)
//        for(String word : words){
//            if(word.startsWith(pref)) count++;
//        }
//        return count;
       // Approach 2 : TC = O(n * k + m ) SC = O(1)
        Trie trie = new Trie();
        for(String word : words){
            trie.add(word);
        }
        return trie.countPrefix(pref);
    }

}
