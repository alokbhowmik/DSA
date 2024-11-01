package LeetCode.java.strings;

/**
 * 
 * Problem Name : Delete Characters to Make Fancy String
 * Problem Link : https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/
 * 
 * Time Complexity  : O(n)
 * Space Complexity : O(n)
 */


public class DeleteCharToMakeFancy {
    public String makeFancyString(String s) {
        if(s.length() < 3) return s;
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0)).append(s.charAt(1));
        int i = 2;
        while(i < s.length()){
            int j = ans.length() - 1;
            if(!(ans.charAt(j) == s.charAt(i) && ans.charAt(j - 1) == s.charAt(i))){
                ans.append(s.charAt(i));
            }
            i++;
        }
        return ans.toString();

    }
}
