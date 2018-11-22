Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.
Use NewTon:
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 1)
            return false;
        int result = num;
        while(result > num/result){
            result = (result+num/result)/2;
        }
        return (result * result == num);
    }
}

solution 2: 
use Bineary Search:
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 1)
            return false;
        int low = 1;
        int high = num;
        while(true){
            int mid = low + (high - low)/2;
            if(mid <= num/mid && (mid+1) > num/(mid+1))
                return (mid*mid == num);
            else if (mid <= num/mid)
                low = mid;
            else
                high = mid;
        }
    }
}
