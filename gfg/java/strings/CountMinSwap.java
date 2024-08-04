package gfg.java.strings;

/*
 * 
 * Problem Name : Count Minimum Swaps
 * Problem Link : https://practice.geeksforgeeks.org/contest/gfg-weekly-166-rated-contest/problems
 * 
 * 
 */
public class CountMinSwap {
    int minSwaps(String S) {
        // code here
        int evenSum = 0, oddSum = 0;
        for(int i=0; i<S.length(); i++){
            if(i%2 == 0){
                evenSum += (S.charAt(i) - '0');
            }else{
                oddSum += (S.charAt(i) - '0');
            }
        }
        if((oddSum + evenSum) %2 == 1) return -1;
        int swap = 0;
        if(oddSum > evenSum){
            for(int i=0; i<S.length(); i+=2){
                if(S.charAt(i) == '0'){
                    swap++;
                    oddSum--;
                    evenSum++;
                }
                if(oddSum == evenSum) break;
            }
        }
        if(evenSum > oddSum){
            for(int i=1; i<S.length(); i+=2){
                if(S.charAt(i) == '0'){
                    swap++;
                    oddSum++;
                    evenSum--;
                }
                if(oddSum == evenSum) break;
            }
        }
        return swap;
    } 
}
