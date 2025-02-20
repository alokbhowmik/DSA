package backtracking;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
*
* Problem Name : Find Unique Binary String
*
* Problem Link : https://leetcode.com/problems/find-unique-binary-string/description/
*
* Problem Statement
*
*
* Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.



Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
Example 2:

Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.
Example 3:

Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.


Constraints:

n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] is either '0' or '1'.
All the strings of nums are unique.
* */
public class FindUniqueBinaryString {
    private String ans = "";
    void solve(StringBuilder sb, Set<String> nums, int len){
        // Tc = O(2^len) SC = O(n) due to set
        if(sb.length() == len){
            if( nums.contains(sb.toString()) ) return ;
            ans = sb.toString();
            return;
        }
        sb.append('0');
        solve(sb, nums, len);
        sb.deleteCharAt(sb.length() - 1); // backtrack
        sb.append('1');
        solve(sb, nums, len);
        sb.deleteCharAt(sb.length() - 1); // backtrack
    }
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, nums);
        Stack<String> stack = new Stack<>();
        stack.push("0");
        stack.push("1");
        while(!stack.isEmpty()){
            String curr = stack.pop();
            if(curr.length() == nums[0].length()){
                if(set.contains(curr)) continue;
                return curr;
            }
            stack.push(curr + "0");
            stack.push(curr + "1");
        }
        return "";
    }
}
