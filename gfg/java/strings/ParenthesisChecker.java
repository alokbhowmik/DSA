package strings;

import java.util.Stack;

/*
*Problem Name : Parenthesis Checker
*
*Problem Link : https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1
*
*Problem Statement : 
*
* Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
An input string is valid if:

         1. Open brackets must be closed by the same type of brackets.
         2. Open brackets must be closed in the correct order.

Examples :

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "([]"
Output: False
Explanation: The expression is not balanced as there is a missing ')' at the end.
Input: s = "([{]})"
Output: False
Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.
Constraints:
1 ≤ s.size() ≤ 106
s[i] ∈ {'{', '}', '(', ')', '[', ']'}
*
* Approach 1 
*--------------
*TC = O(n) SC = O(n)
*/
public class ParenthesisChecker{
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> st = new Stack();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else if(!st.isEmpty() && (( ch == ')' && st.peek() == '(') || (ch == '}' && st.peek() == '{') || (ch == ']' && st.peek() == '['))){
                // Close Bracket
                st.pop();
            }else{
                return false;
            }
        }
        return st.isEmpty();
    }
}