Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0

The idea is to find the point that nums[i] > nums[i+1]

class Solution {
    public int findMin(int[] nums) {
        for(int i = 0; i < nums.length;i++){
            if(i==0 && nums[nums.length -1] >= nums[i])
                return nums[i];
            if(i > 0 && nums[i-1] > nums[i])
                return nums[i];
        }
        return -1;
    }
}
