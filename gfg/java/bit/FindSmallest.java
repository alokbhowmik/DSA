/**
 * Problem Name : Find Smallest 
 * Problem Link : https://practice.geeksforgeeks.org/contest/gfg-weekly-170-rated-contest/problems
 * 
 * Not able to copy the problem statement. Kindly check the above Lin

 * 
 * Time Complexity : O(1) 
 * Space Complexity : O(1)
 * 
 */
class FindSmallest {

    public static int getSmallest(int n) {
        // code here
        for(int i=0; i<32; i++){
            int val = (1 << i) & n;
            if(val== 0){
                return 1<<i;
            }
        }
        return -1;
    }
}