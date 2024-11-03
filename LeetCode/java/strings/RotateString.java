package LeetCode.java.strings;

/**
 * Problem Name : Rotate String
 * Problem Link : https://leetcode.com/problems/rotate-string/description/
 * 
 * Time Complexity : O(n) 
 * Space Complexity : O(n)
 */

class RotateString{
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}

