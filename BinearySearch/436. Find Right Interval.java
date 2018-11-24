Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
\
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length;i++){
            map.put(intervals[i].start, i);
        }
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            if(map.containsKey(intervals[i].end)){
                res[i] = map.get(intervals[i].end);
                continue;
            }
            Map.Entry<Integer, Integer> higher = map.higherEntry(intervals[i].end);
            if(higher == null)
                res[i] = -1;
            else
                res[i] = higher.getValue();
        }
        return res;
    }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return new int[0];
        int N = intervals.length;
        if(N==1)
            return new int[]{-1};
        int [] start = new int[N];
        HashMap<Integer, Integer> pair = new HashMap<>();
        for(int i = 0; i < N; i++){
            start[i] = intervals[i].start;
            pair.put(start[i],i);
        }
        Arrays.sort(start);
        int[] res = new int[N];
        for(int i = 0; i < N; i++){
            int end = intervals[i].end;
            int x = Arrays.binarySearch(start,end);
            if(x > 0){
                res[i] = pair.get(end);
            }else if(-x > N)
                res[i] = -1;
            else
                res[i] = pair.get(start[-x-1]);
        }
        return res;
    }
}
