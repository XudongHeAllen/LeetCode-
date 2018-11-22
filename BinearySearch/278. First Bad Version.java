pretty simple question
No difference between normal bineary search question

Here is solution:

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while(low < high){
            int mid = (low + (high-low)/2);
            if (!isBadVersion(mid)){
                low = mid + 1;
            }
            else
                high = mid;
            }
        return low;
        }
    }
