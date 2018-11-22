Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
             
Those year's Newton's algorithm is more and more popular for this question and it is also easy to under stand

But there is a limit here,
If the input interger is too big, the x * x will lead to overflow and get wrong answers.

class Solution {
    public int mySqrt(int x) {
        if(x <= 1)
            return x;
        int mid, low = 0;
        int high = x;
        while(true){
            mid = (low + high)/2;
            if(mid <= x/mid && (mid+1) > x/(mid+1))
                return mid;
            else if(mid < x/mid)
                low = mid;
            else
                high = mid;
        }
    }
}
