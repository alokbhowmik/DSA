package slidingWindow;

/*
*Problem Name : Number of Substrings Containing All Three Characters
*
*Problem Link : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/?envType=daily-question&envId=2025-03-11
*
*Problem Statement : 
*Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.



Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
Example 3:

Input: s = "abc"
Output: 1


Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
* Approach 1 
*--------------
*TC = O(n) SC = O(1)
*/
public class NumberOfSubstringsContainingAllThreeCharacters{
    public int numberOfSubstrings(String s) {
        /**
         * abcabc
         * abc = 1
         * abca = abca + bca = 2
         * abcab = abcab + bcab + cab = 3
         * abcabc = abcabc + bcabc + cabc + abc = 4
         *
         */
        int a = 0, b = 0, c = 0, ans = 0, count = 0;
        int l = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                a++;
            }
            if (ch == 'b')
                b++;
            if (ch == 'c')
                c++;

            while(a > 0 && b > 0 && c > 0){
                count++;
                char ch1 = s.charAt(l++);
                if(ch1 == 'a') a--;
                if(ch1 == 'b') b--;
                if(ch1 == 'c') c--;
            }
            ans += count;
        }
        return ans;
    }
}