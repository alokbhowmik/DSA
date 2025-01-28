package backtraking;
import  java.util.*;

/*
*
* Problem Name : Permutations of a String
* Problem Link : https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
*
* Problem Statement
*
* Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

Examples:

Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has 6 unique permutations.
Input: s = "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 unique permutations.
Input: s = "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same.
Constraints:
1 <= s.size() <= 9
s contains only Uppercase english alphabets
* */
public class PermutationsOfAString {
    public ArrayList<String> findPermutation(String s) {
        // Code herec
        ArrayList<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        backtrack(res, new StringBuilder(), chars, visited);
        return res;
    }

    void backtrack(ArrayList<String> res, StringBuilder sb, char[] chars, boolean[] visited){
        if(sb.length() == chars.length ) {
            res.add(sb.toString());
            return;
        }
        for(int i = 0; i<chars.length; i++){
            if(visited[i]) continue;
            if(i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            sb.append(chars[i]);
            backtrack(res, sb, chars, visited);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
