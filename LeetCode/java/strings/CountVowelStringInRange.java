package strings;

/***
 *
 * Problem Name : Count Vowel Strings in Ranges
 * Problem Link : https://leetcode.com/problems/count-vowel-strings-in-ranges/description/
 *
 * Problem statement
 * You are given a 0-indexed array of strings words and a 2D array of integers queries.
 *
 * Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.
 *
 * Return an array ans of size queries.length, where ans[i] is the answer to the ith query.
 *
 * Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
 * Output: [2,3,0]
 * Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
 * The answer to the query [0,2] is 2 (strings "aba" and "ece").
 * to query [1,4] is 3 (strings "ece", "aa", "e").
 * to query [1,1] is 0.
 * We return [2,3,0].
 * Example 2:
 *
 * Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
 * Output: [3,2,1]
 * Explanation: Every string satisfies the conditions, so we return [3,2,1].
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 10^5
 * 1 <= words[i].length <= 40
 * words[i] consists only of lowercase English letters.
 * sum(words[i].length) <= 3 * 10^5
 * 1 <= queries.length <= 10^5
 * 0 <= li <= ri < words.length
 * */
public class CountVowelStringInRange {
    public int[] vowelStrings(String[] words, int[][] queries) {
        // TC = O(N + M) SC = O(N + M )
        int n = words.length, m = queries.length;
        int[] prefix = new int[n];
        int[] ans = new int[m];
        for (int i = 0; i < n; i++) {
            prefix[i] = hasStartEndVowel(words[i]) ? 1 : 0;
            if (i > 0) prefix[i] += prefix[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l == 0) ans[i] = prefix[r];
            else ans[i] = prefix[r] - prefix[l - 1];
        }
        return ans;
    }

    private boolean hasStartEndVowel(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}