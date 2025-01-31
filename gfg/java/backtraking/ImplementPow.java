package backtraking;
/*
* Problem Name : Implement Pow
*
* Problem Link : https://www.geeksforgeeks.org/problems/powx-n/1
*
* Problem Statement
*
* Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).

Examples:

Input: b = 3.00000, e = 5
Output: 243.00000
Input: b = 0.55000, e = 3
Output: 0.16638
Input: b = -0.67000, e = -7
Output: -16.49971
Constraints:

-100.0 < b < 100.0
-109 <= e <= 109
Either b is not zero or e > 0.
-104 <= be <= 104
* */
public class ImplementPow {
    double power(double b, int e) {
        // code here
//        return Math.pow(b, e);
        if(e == 0) return 1;
        if(e == 1) return b;

        boolean neg = (e < 0);
        e = Math.abs(e);
        double sol = power(b, e/2);
        double ans ;
        if(e % 2 == 0){
            ans = sol * sol;
        }else{
            ans = b * sol * sol;
        }
        return neg ? 1.0 / ans : ans;
    }
}
