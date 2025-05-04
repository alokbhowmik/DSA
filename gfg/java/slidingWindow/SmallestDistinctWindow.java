package slidingWindow;

/*
*Problem Name : Smallest distinct window
*
*Problem Link : https://www.geeksforgeeks.org/problems/smallest-distant-window3132/1
*
*Problem Statement : 
*
* Given a string str, your task is to find the length of the smallest window that contains all the characters of the given string at least once.

Example:

Input: str = "aabcbcdbca"
Output: 4
Explanation: Sub-String "dbca" has the smallest length that contains all the characters of str.
Input: str = "aaab"
Output: 2
Explanation: Sub-String "ab" has the smallest length that contains all the characters of str.
Input: str = "geeksforgeeks"
Output: 8
Explanation: There are multiple substring with smallest length that contains all characters of str, "geeksfor" and "forgeeks".
Constraints:
1 ≤ str.size() ≤ 10^5
str contains only lower-case english alphabets.
* Approach 1  : Sliding Window
*--------------
*TC = O(n) SC = O(1)
*/
public class SmallestDistinctWindow{
    public int findSubString(String str) {
        // code here
        int freq[] = new int[26];
        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }
        int total = 0;
        for (int num : freq) {
            if (num > 0) total++;
        }
        int count = 0;
        int l = 0, r = 0;
        int freq2[] = new int[26];
        int res = Integer.MAX_VALUE;

        while (r < str.length()) {
            //System.out.println("r= " + r +"count = " + count);
            char ch2 = str.charAt(r);
            freq2[ch2 - 'a']++;
            if (freq2[ch2 - 'a'] == 1) count++;
            while (l <= r && count >= total) {
                // System.out.println("l= " + l + "r=" + r);
                res = Math.min(res, r - l + 1);
                char ch = str.charAt(l);
                freq2[ch - 'a']--;
                if (freq2[ch - 'a'] == 0) count--;
                l++;
            }
            r++;
        }
        return res;
    }
}