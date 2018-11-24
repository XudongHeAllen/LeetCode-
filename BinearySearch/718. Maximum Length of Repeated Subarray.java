Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
Note:
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100


class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if(m == 0 || n ==0)
            return 0;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = m -1; i >= 0; i--)
            for(int j = n-1; j >= 0; j--)
                max = Math.max(max,dp[i][j] = A[i] == B[j] ? 1+dp[i+1][j+1] : 0);
        return max;
    }
}

faster:
class Solution {
    public int findLength(int[] A, int[] B) {
        if(A == null || B == null)
            return 0;
        int m = A.length;
        int n = B.length;
        int[] dp = new int[n+1];
        int max = 0;
        
        for(int i = 1; i <= m; i++){
            for(int j = n; j > 0; j--){
                if(A[i-1] == B[j-1]){
                    dp[j] = 1 + dp[j-1];
                    max = Math.max(max, dp[j]);
                }
                else{
                    dp[j] = 0;
                }
            }
        }
        return max;
    
    }
}
