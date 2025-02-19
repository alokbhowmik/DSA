package backtracking;
/*
*
* Problem Name : The k-th Lexicographical String of All Happy Strings of Length n
*
* Problem Link : https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
*
* Problem Statement :
* A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.



Example 1:

Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
Example 2:

Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.
Example 3:

Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"


Constraints:

1 <= n <= 10
1 <= k <= 100
* */

import java.util.ArrayList;

public class K_thLexicographicalStringOfAllHappyStringsOfLength_n {
    private final ArrayList<String> res = new ArrayList<>();
    private final char[] chars = {'a', 'b', 'c'};

    private void solve(StringBuilder sb, int n, int k){
        // TC = O(n * 2^n) SC = O(k)
        if(sb.length() == n){
            res.add(sb.toString());
            return;
        }
        if(res.size() == k) return;
        for(char ch : chars){
            if(sb.isEmpty()){
                sb.append(ch);
            }else if(sb.charAt(sb.length() - 1) != ch){
                sb.append(ch);
            }else{
                continue;
            }
            solve(sb, n, k);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

    }
    public String getHappyString(int n, int k) {
        solve(new StringBuilder(), n, k);
        // Collections.sort(res);
        return res.size() >= k ? res.get(k - 1) : "";
    }
}
