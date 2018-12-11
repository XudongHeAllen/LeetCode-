
Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
Note:
The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, new ArrayList<Integer>());
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums,int index,List<Integer> list){
        Set<Integer> used = new HashSet<>();
        for(int i = index; i<nums.length;i++){
            if(i != index && used.contains(nums[i]))
                continue;
            used.add(nums[i]);
            if(list.isEmpty() || nums[i] >= list.get(list.size() -1)){
                list.add(nums[i]);
                if(list.size() >= 2){
                    res.add(new ArrayList<Integer>(list));
                }
                helper(res,nums,i+1, list);
                list.remove(list.size() -1);
            }
        }
    }
}
