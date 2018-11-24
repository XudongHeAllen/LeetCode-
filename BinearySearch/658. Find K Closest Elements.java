Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:

The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = Arrays.binarySearch(arr,x);
        if(index < 0)
            index = -index - 1;
        List<Integer> res = new ArrayList<>();
        int left = index - 1;
        int right = index;
        while(k-- > 0){
            if(right >= arr.length||( left >= 0 && Math.abs(x - arr[left]) <= Math.abs(x - arr[right])))
                res.add(0,arr[left--]);
            else
                res.add(arr[right++]);
        }
        return res;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new LinkedList<>();
        
        if(arr == null || arr.length == 0)
            return list;
        int left = 0;
        int right = arr.length -k;
        while(left < right){
            int mid = left + (right - left)/2;
            if(x - arr[mid] > arr[mid+k] -x)
                left = mid + 1;
            else
                right = mid;
        }
        
        for(int i = left; i < left + k; i ++)
            list.add(arr[i]);
        return list;
    }
}
