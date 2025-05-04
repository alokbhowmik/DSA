package array;

/*
*Problem Name : Number of Equivalent Domino Pairs
*
*Problem Link : https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/?envType=daily-question&envId=2025-05-04
*
*Problem Statement : 
*
* Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].



Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
Example 2:

Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
Output: 3


Constraints:

1 <= dominoes.length <= 4 * 10^4
dominoes[i].length == 2
1 <= dominoes[i][j] <= 9
*
* Approach 1 
*--------------
*TC = O(n) SC = O(1)
*/
public class NumberOfEquivalentDominoPairs{
    public int numEquivDominoPairs(int[][] dominoes) {
        // 21 = 2 43 = 1 65 = 1
        int[] map = new int[100];
        for(int[] dom : dominoes){
            if(dom[0] > dom[1]) {
                map[dom[0] * 10 + dom[1]]++;
            }else{
                map[dom[1] * 10 + dom[0]]++;
            }
        }
        int count = 0;
        for(int num : map){
            count += num * (num - 1)/2;
        }
        return count;
    }
}