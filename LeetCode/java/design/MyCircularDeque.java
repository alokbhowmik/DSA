package LeetCode.java.design;

/**
 * 
 * Problem Name : Design Circular Deque
 * Problem Link : https://leetcode.com/problems/design-circular-deque/description/
 * 
 * Problem Statement 
 * 
 * Design your implementation of the circular double-ended queue (deque).

Implement the MyCircularDeque class:

MyCircularDeque(int k) Initializes the deque with a maximum size of k.
boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
boolean isEmpty() Returns true if the deque is empty, or false otherwise.
boolean isFull() Returns true if the deque is full, or false otherwise.
 

Example 1:

Input
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 2, true, true, true, 4]

Explanation
MyCircularDeque myCircularDeque = new MyCircularDeque(3);
myCircularDeque.insertLast(1);  // return True
myCircularDeque.insertLast(2);  // return True
myCircularDeque.insertFront(3); // return True
myCircularDeque.insertFront(4); // return False, the queue is full.
myCircularDeque.getRear();      // return 2
myCircularDeque.isFull();       // return True
myCircularDeque.deleteLast();   // return True
myCircularDeque.insertFront(4); // return True
myCircularDeque.getFront();     // return 4
 

Constraints:

1 <= k <= 1000
0 <= value <= 1000
At most 2000 calls will be made to insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull.
    
*/
class MyCircularDeque {
    class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
            prev = null;
            next = null;
        }
    }

    int size, k;
    Node font = null, rear = null;

    public MyCircularDeque(int k) {
        this.k = k;
        this.size = k;
    }

    public boolean insertFront(int value) {
        // System.out.println(value + ":" + isFull());
        // TC = O(1)
        if (!isFull()) {
            Node node = new Node(value);
            if (isEmpty()) {
                font = node;
                rear = node;
            } else {
                node.next = font;
                font.prev = node;
                font = node;
            }
            rear.next = font;
            size--;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        // System.out.println(value + " " + isFull());
        // TC = O(1)
        if (!isFull()) {
            Node node = new Node(value);
            if (isEmpty()) {
                font = node;
                rear = node;
            } else {
                node.prev = rear;
                rear.next = node;
                rear = node;
            }
            rear.next = font;
            size--;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        // TC = O(1)
        if (isEmpty())
            return false;
        if (font == rear) {
            font = null;
            rear = null;
            size = k;
            return true;
        }
        Node temp = font.next;
        font = null;
        font = temp;
        rear.next = font;
        size++;
        return true;
    }

    public boolean deleteLast() {
        // TC = O(1)
     if(isEmpty()) return false;
     if(font == rear){
        font = null;
        rear = null;
        size = k;
        return true;
     }   
     
     rear = rear.prev;
     rear.next = font;
     size++;
     return true;

    }

    public int getFront() {
        // TC = O(1)
        return font == null ?-1: font.val;
    }

    public int getRear() {
        // TC = O(1)
        return rear == null ? -1 : rear.val;
    }

    public boolean isEmpty() {
        // TC = O(1)
        return this.k == this.size;
    }

    public boolean isFull() {
        // TC = O(1)
        return this.size == 0;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
