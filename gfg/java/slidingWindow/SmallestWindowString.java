package gfg.java.slidingWindow;

/**
 * 
 * Problem Name : Smallest window in a string containing all the characters of another string
 * Problem Link : https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
 * 
 * Problem Statement
 * ==========================
 * 
 * Given two strings s and p. Find the smallest window in the string s consisting of all the characters(including duplicates) of the string p.  Return "-1" in case there is no such window present. In case there are multiple such windows of same length, return the one with the least starting index.
Note : All characters are in Lowercase alphabets. 

Examples:

Input: s = "timetopractice", p = "toc"
Output: toprac
Explanation: "toprac" is the smallest
substring in which "toc" can be found.
Input: s = "zoomlazapzo", p = "oza"
Output: apzo
Explanation: "apzo" is the smallest 
substring in which "oza" can be found.
Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(n), n = len(p)

Constraints: 
1 ≤ |s|, |p| ≤ 10^5
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
public class SmallestWindowString {
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int freqP[] = new int[26];
        int freqS[] = new int[26];
        for(char ch : p.toCharArray()){
            freqP[ch - 'a']++;
        }
        int m = p.length();
        int j = 0, i = 0, left = 0, right = s.length();
        int minSize = Integer.MAX_VALUE;
        int cnt = 0;
        while(i < s.length()){
            int ch = s.charAt(i) - 'a';
            freqS[ch]++;
            if(freqP[ch] != 0 && freqP[ch] >= freqS[ch]){
                cnt++;
            }
            while(cnt == m){
                int size = i - j + 1;
                int chj = s.charAt(j) - 'a';
                if(size < minSize ){
                    minSize = size;
                    left = j;
                    right = i;
                }
                freqS[chj]--;
                if(freqS[chj] < freqP[chj]){
                    cnt--;
                }
                j++;
                
            }
            i++;
        }
        return minSize == Integer.MAX_VALUE ?"-1" : s.substring(left, right + 1);
    } 
}
