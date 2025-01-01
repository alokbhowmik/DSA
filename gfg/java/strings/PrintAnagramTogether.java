package strings;

import java.util.*;

/**
 * Problem Name : Print Anagrams Together
 * Problem Link : https://www.geeksforgeeks.org/problems/print-anagrams-together/1
 * Problem Statement
 *
 * Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.
 *
 * Note: The final output will be in lexicographic order.
 *
 * Examples:
 *
 * Input: arr[] = ["act", "god", "cat", "dog", "tac"]
 * Output: [["act", "cat", "tac"], ["god", "dog"]]
 * Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.
 * Input: arr[] = ["no", "on", "is"]
 * Output: [["is"], ["no", "on"]]
 * Explanation: There are 2 groups of anagrams "is" makes group 1. "no", "on" make group 2.
 * Input: arr[] = ["listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"]
 * Output: [["abc", "cab", "bac"], ["listen", "silent", "enlist"], ["rat", "tar", "art"]]
 * Explanation:
 * Group 1: "abc", "bac", and "cab" are anagrams.
 * Group 2: "listen", "silent", and "enlist" are anagrams.
 * Group 3: "rat", "tar", and "art" are anagrams.
 * Constraints:
 * 1<= arr.size() <=100
 * 1<= arr[i].size() <=10
 */
public class PrintAnagramTogether {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        //["act", "god", "cat", "dog", "tac"]
        //
        // act, act
        Map<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();

        for(String word : arr){ // (N)
            String key = generateKey(word);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);

        }

        for(ArrayList<String> lst : map.values()){
            res.add(lst);
        }
        return res;
    }
    private String generateKey(String str){
        int freq[] = new int[26];
        for(char ch : str.toCharArray()) freq[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        for(int f : freq){
            sb.append(f).append("_");
        }
        return sb.toString();
    }
}
