package array;

import java.util.PriorityQueue;

/*
*
* Problem Name : K Closest Points to Origin
*
* Problem Link : https://www.geeksforgeeks.org/problems/k-closest-points-to-origin--172242/1
*
* Problem Statement
*
* Given an array of points where each point is represented as points[i] = [xi, yi] on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance, defined as:

sqrt( (x2 - x1)2 + (y2 - y1)2 )

Note: You can return the k closest points in any order, driver code will sort them before printing.

Examples:

Input: k = 2, points[] = [[1, 3], [-2, 2], [5, 8], [0, 1]]
Output: [[-2, 2], [0, 1]]
Explanation: The Euclidean distances from the origin are:
Point (1, 3) = sqrt(10)
Point (-2, 2) = sqrt(8)
Point (5, 8) = sqrt(89)
Point (0, 1) = sqrt(1)
The two closest points to the origin are [-2, 2] and [0, 1].
Input: k = 1, points = [[2, 4], [-1, -1], [0, 0]]
Output: [[0, 0]]
Explanation: The Euclidean distances from the origin are:
Point (2, 4) = sqrt(20)
Point (-1, -1) = sqrt(2)
Point (0, 0) = sqrt(0)
The closest point to origin is (0, 0).
Constraints:

1 <= k <= points.size() <= 10^5
-10^4 <= xi, yi <= 10^4
 *
*
* */
public class K_ClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        // Your code here TC = O(n log(k)) SC = O(k)
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] arr, int[] brr)->{
            if(Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1]) < Math.sqrt(brr[0] * brr[0] + brr[1] * brr[1]))
            {
                return 1;
            }
            return -1;
        });
        int[][] res = new int[k][2];
        for(int[] point : points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll();
            i++;
        }
        return res;
    }
}
