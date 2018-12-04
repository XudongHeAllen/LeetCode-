Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.
Example 2:
Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:
Input: [-1, 3, 2, 0]

Output: True

Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for(int n : nums){
            if(stack.isEmpty() || n<stack.peek().min)
                stack.push(new Pair(n,n));
            else if(n > stack.peek().min ){
                Pair last = stack.pop();
                if(n < last.max)
                    return true;
                else{
                    last.max = n;
                    while(!stack.isEmpty() && n >= stack.peek().max)
                        stack.pop();
                    if(!stack.isEmpty() && stack.peek().min < n)
                        return true;
                    stack.push(last);
                }
            }
        }
        return false;
    }
}
class Pair{
    int max, min;
    public Pair(int max, int min){
        this.max = max;
        this.min = min;
    }
}

import java.util.*;

public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums==null && nums.length<3) {
            return false;
        }
        
        /*
        //find 3 2 case and keep 3 and 2 as large as possible
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE; //second is the 2 in 132
        int t;
        for (int i = nums.length-1; i >= 0; i--) {
            t = nums[i];
            if (t < second) {
                return true;
            }
            //elements in stack should be like 2,3,4,5 (larger and larger)
            while (!stack.isEmpty() && t > stack.peek()) { //32 case occur, find the largest second while t is the 3
                second = stack.pop();
            }
            stack.push(t);//still need to keep t
        }
        */
        //use the tail of the nums as stack
        int top = nums.length;
        int second = Integer.MIN_VALUE; //second is the 2 in 132
        int t;
        for (int i = nums.length-1; i >= 0; i--) {
            t = nums[i];
            if (t < second) {
                return true;
            }
            while (top < nums.length && t > nums[top]) { 
                second = nums[top++];
            }
            nums[--top]=t;
        }
        return false;
    }
}
