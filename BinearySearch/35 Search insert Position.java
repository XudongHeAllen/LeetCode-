First i tried binary Search, but the time limition expired
Then i tired more dum way, directly compare elements in array with target one by one
Used 5 line and 2 ms
Here is the solution

class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target)
                return i;
        }
        return nums.length;
    }
 }
