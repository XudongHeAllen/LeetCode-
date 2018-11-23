Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.

class Solution {
    public int divide(int dividend, int divisor) {
        //first we need to decide our sign
        int sign = (dividend < 0 ^ divisor < 0 )? -1:1;
        
        //deal with edge case
        if(dividend == Integer.MIN_VALUE && divisor == -1) 
            return Integer.MAX_VALUE;
        if(dividend > 0)
            dividend = - dividend;
        if(divisor > 0)
            divisor =  - divisor;
        if(dividend > divisor)
            return 0;
        
        int result = 0;
        int temp = divisor;
        int count = 1;
        //first we need to finded the largest possible divisor
        while (dividend - temp <= temp)
        {
            temp <<= 1; //double
            count <<= 1; //double
        }
        while(dividend < 0){
            if(dividend - temp > 0){
                temp >>= 1;
                count >>= 1;
                continue;
            }
            result |= count;
            dividend -= temp;
        }
        return sign == -1 ? -result:result;
    }
}
