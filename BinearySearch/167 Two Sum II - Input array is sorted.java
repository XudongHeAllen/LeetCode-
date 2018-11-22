Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific
target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less 
than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.


My idea is using two pointers
One point to the start of array and another point to the end
If start + end > target
means we need to move end to make it smaller
If start + end < target
means we need to move start to make it bigger

Here is the solution:


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        int[] result = new int[2];
        while(low < high){
            if(numbers[low] + numbers[high] == target){
                result[0] = low+1;
                result[1] = high+1;
                return result;
            }
            else if (numbers[low] + numbers[high] > target)
                high--;
            else
                low++;
        }
        return result;
    }
}
