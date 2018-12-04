Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 

Note:

1 <= A.length <= 30000
1 <= A[i] <= 30000
 class Solution {
    public int sumSubarrayMins(int[] A) {
        //If we know the index of prevLess, nextLess => (i-prevLess)*(nextLess-i) is the contribution
        //when we have n[i] = prevLess, no need to stack. keep prev = n[prev] until n[prev] < n[i]
        int[] n = new int[A.length];
        int[] p = new int[A.length];
        
        p[0] = -1;
        for (int i = 1; i < A.length; i++) {
            int prev = i - 1;
            while (prev >= 0 && A[prev] >= A[i]) {
                prev = p[prev];
            }
            p[i] = prev;
        }
        
        n[A.length - 1] = A.length;
        for (int i = A.length-2; i >=0; i--) {
            int next = i + 1;
            while (next < A.length && A[next] > A[i]) {
                next = n[next];
            }
            n[i] = next;
        }
        
        int rtn = 0;
        int modulo = (int)Math.pow(10, 9) + 7;
        for (int i = 0; i< A.length; i++) {
            rtn += A[i] * (i - p[i]) * (n[i] - i);
            if (rtn > modulo) {
                rtn %= modulo;
            }
        }
        
        return rtn;
    }
}
