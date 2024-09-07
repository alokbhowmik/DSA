package LeetCode.java.array;

import java.util.*;

/**
 * 
 * 
 * Problem Name : Walking Robot Simulation 874
 * Problem Link : https://leetcode.com/problems/walking-robot-simulation/description/?envType=daily-question&envId=2024-09-04
 * 
 * Problem Statement 
 * ===================
 * 
 * A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot receives an array of integers commands, which represents a sequence of moves that it needs to execute. There are only three possible types of instructions the robot can receive:

-2: Turn left 90 degrees.
-1: Turn right 90 degrees.
1 <= k <= 9: Move forward k units, one unit at a time.
Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs into an obstacle, it will stay in its current location (on the block adjacent to the obstacle) and move onto the next command.

Return the maximum squared Euclidean distance that the robot reaches at any point in its path (i.e. if the distance is 5, return 25).

Note:

There can be an obstacle at (0, 0). If this happens, the robot will ignore the obstacle until it has moved off the origin. However, it will be unable to return to (0, 0) due to the obstacle.
North means +Y direction.
East means +X direction.
South means -Y direction.
West means -X direction.
 

Example 1:

Input: commands = [4,-1,3], obstacles = []

Output: 25

Explanation:

The robot starts at (0, 0):

Move north 4 units to (0, 4).
Turn right.
Move east 3 units to (3, 4).
The furthest point the robot ever gets from the origin is (3, 4), which squared is 32 + 42 = 25 units away.

Example 2:

Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]

Output: 65

Explanation:

The robot starts at (0, 0):

Move north 4 units to (0, 4).
Turn right.
Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
Turn left.
Move north 4 units to (1, 8).
The furthest point the robot ever gets from the origin is (1, 8), which squared is 12 + 82 = 65 units away.

Example 3:

Input: commands = [6,-1,-1,6], obstacles = [[0,0]]

Output: 36

Explanation:

The robot starts at (0, 0):

Move north 6 units to (0, 6).
Turn right.
Turn right.
Move south 5 units and get blocked by the obstacle at (0,0), robot is at (0, 1).
The furthest point the robot ever gets from the origin is (0, 6), which squared is 62 = 36 units away.

 

Constraints:

1 <= commands.length <= 10^4
commands[i] is either -2, -1, or an integer in the range [1, 9].
0 <= obstacles.length <= 10^4
-3 * 10^4 <= xi, yi <= 3 * 10^4
The answer is guaranteed to be less than 231.
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        int dirs[][] = {{0,1},{1, 0}, {0, -1}, {-1, 0}};
        int pos = 0;
        int x = 0, y = 0;
        int furthestPoint = 0;
        for(int[] point : obstacles){
            set.add(point[0] + "@" + point[1]);
        }
        for(int cmd : commands){
            if(cmd == -1){
                pos = (pos + 1) % 4;
            }else if(cmd == -2){
                pos = (pos + 3) % 4;
            }else{
                for(int i=0; i<cmd; i++){
                    int dx = x + dirs[pos][0];
                    int dy = y + dirs[pos][1];
                    if(set.contains(dx+"@"+dy)){
                        break;
                    }
                    x = dx;
                    y = dy;
                    furthestPoint = Math.max(furthestPoint, x*x + y*y);
                    //System.out.println(dx + "::" + dy + "::" + furthestPoint);
                }
            }
        }
        return furthestPoint;

    }
}
