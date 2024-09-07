package LeetCode.java.LinkedList;

import java.util.*;

/**
 * 
 * Problem Name  : Delete Nodes From Linked List Present in Array
 * Problem Link : https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/?envType=daily-question&envId=2024-09-06
 * 
 * Problem Statement 
 * ============================
 * 
 * You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.

 

Example 1:

Input: nums = [1,2,3], head = [1,2,3,4,5]

Output: [4,5]

Explanation:



Remove the nodes with values 1, 2, and 3.

Example 2:

Input: nums = [1], head = [1,2,1,2,1,2]

Output: [2,2,2]

Explanation:



Remove the nodes with value 1.

Example 3:

Input: nums = [5], head = [1,2,3,4]

Output: [1,2,3,4]

Explanation:



No node has value 5.

 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
All elements in nums are unique.
The number of nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
The input is generated such that there is at least one node in the linked list that has a value not present in nums.


& Time Complexity : O(n)
& Space Complexity : O(m)
 */
public class DeleteNodeFromArray {
 //   Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode curr = head, prev = null;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        while(curr != null){
            if(set.contains(curr.val)){
                if(curr == head){
                    head = head.next;
                    curr = curr.next;
                }else{
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
