package gfg.java.array;
import java.util.*;;

/**
 * 
 * Problem Name  : Sorting Elements of an Array by Frequency
 * Problem Link  : https://www.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621/1
 * 
 * Problem Statement 
 * 
 * Given an array of integers arr, sort the array according to the frequency of elements, i.e. elements that have higher frequency comes first. If the frequencies of two elements are the same, then the smaller number comes first.

Examples :

Input: arr[] = [5, 5, 4, 6, 4]
Output: [4, 4, 5, 5, 6]
Explanation: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are the same the smaller element comes first. So 4 4 comes first then comes 5 5. Finally comes 6. The output is 4 4 5 5 6.
Input: arr[] = [9, 9, 9, 2, 5]
Output: [9, 9, 9, 2, 5]
Explanation: The highest frequency here is 3. Element 9 has the highest frequency So 9 9 9 comes first. Now both 2 and 5 have the same frequency. So we print smaller elements first. The output is 9 9 9 2 5.
Expected Time Complexity: O(n*logn)
Expected Space Complexity: O(n)

Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i]≤ 10^5
 * 
 * Time Complexity = O(nlog(n))
 * Space Complexity = O(n) // due to PriorityQueue and Map
 */

public class FrequencySort {
    class Pair implements Comparable<Pair>{
        int num, freq;
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
        
        public int compareTo(Pair p){
            if(p.freq == this.freq){
                return this.num - p.num;
            }
            return p.freq - this.freq;
        }
    }
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: arr){   // O(n)
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int num : map.keySet()){ // O(n)
            pq.offer(new Pair(num, map.get(num))); // log(n)
        }
        ArrayList<Integer> lst = new ArrayList<>();
        while(!pq.isEmpty()){ // O(n)
            while(pq.peek().freq-- > 0){
                lst.add(pq.peek().num);
            }
            pq.poll();
        }
        return lst;
    }
}
