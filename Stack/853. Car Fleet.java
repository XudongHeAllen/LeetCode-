N cars are going to the same destination along a one lane road.  The destination is target miles away.

Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.

A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

The distance between these two cars is ignored - they are assumed to have the same position.

A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.


How many car fleets will arrive at the destination?

 

Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.

Note:

0 <= N <= 10 ^ 4
0 < target <= 10 ^ 6
0 < speed[i] <= 10 ^ 6
0 <= position[i] < target
All initial positions are different.

logic:

if two fleets reach the target at the same time, they can be considered the same fleet (learned from first example)
but, if one fleet that is ahead of another takes longer, they too can be considered the same (also the first example)
therefore, it makes sense that starting from the fleet closest to the target, all following fleets that are faster than the first fleet all join the same fleet, until a slower fleet appears, starting the next fleet.

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> posSpeed = new HashMap<>();
        for(int i = 0; i < position.length; i ++){
            posSpeed.put(position[i], speed[i]);
        }
        int res = 0;
        double minTime = 0.0;
        Arrays.sort(position);
        for(int i = position.length -1 ; i >= 0 ;i--){
            double timeTake = (double) (target - position[i])/posSpeed.get(position[i]);
            if(minTime<timeTake){
                res++;
                minTime = timeTake;
            }
        }
        return res;
    }
}
