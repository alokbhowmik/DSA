package priorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
*
* Problem Name : Find median in a stream
*
* Problem Link : https://www.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
*
* Problem statement
*
* Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.

There are two cases for median on the basis of data set size.

1. If the data set has an odd number then the middle one will be consider as median.
2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.

Examples:

Input:  arr[] = [5, 15, 1, 3, 2, 8]
Output: [5.0, 10.0, 5.0, 4.0, 3.0, 4.0]
Explanation:
After reading 1st element of stream – 5 -> median = 5.0
After reading 2nd element of stream – 5, 15 -> median = (5+15)/2 = 10.0
After reading 3rd element of stream – 5, 15, 1 -> median = 5.0
After reading 4th element of stream – 5, 15, 1, 3 ->  median = (3+5)/2 = 4.0
After reading 5th element of stream – 5, 15, 1, 3, 2 -> median = 3.0
After reading 6th element of stream – 5, 15, 1, 3, 2, 8 ->  median = (3+5)/2 = 4.0
Input: arr[] = [2, 2, 2, 2]
Output: [2.0, 2.0, 2.0, 2.0]
Explanation:
After reading 1st element of stream – 2 -> median = 2.0
After reading 2nd element of stream – 2, 2 -> median = (2+2)/2 = 2.0
After reading 3rd element of stream – 2, 2, 2 -> median = 2.0
After reading 4th element of stream – 2, 2, 2, 2 ->  median = (2+2)/2 = 2.0
Constraints:
1 <= arr.size() <= 10^5
1 <= x <= 10^6
 * */
public class FindMedianInAStream {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        PriorityQueue<Integer> min = new PriorityQueue();
        PriorityQueue<Integer> max = new PriorityQueue(Collections.reverseOrder());
        ArrayList<Double> res = new ArrayList<>();

        for(int num : arr){
            add(num, min, max);
            res.add(median(max, min));
        }
        return res;
    }
    private double median(PriorityQueue<Integer> max, PriorityQueue<Integer> min){
        if(max.size() > min.size() ) return max.peek()/1.0;
        return (max.peek() + min.peek() ) /2.0;
    }
    private void add(int num, PriorityQueue<Integer> min, PriorityQueue<Integer> max){
        if(max.isEmpty() || max.peek() >= num){
            max.offer(num);
        }else{
            min.offer(num);
        }

        if(max.size() > min.size() + 1){
            min.offer(max.poll());
        }else if(min.size() > max.size() ){
            max.offer(min.poll());
        }
    }
}
