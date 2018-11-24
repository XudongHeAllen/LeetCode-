In an election, the i-th vote was cast for persons[i] at time times[i].

Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.  

Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.

 

Example 1:

Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
Explanation: 
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.

class TopVotedCandidate {
    int [] leading;
    int [] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int max = 0;
        int [] people = new int[persons.length + 1];
        leading = new int[persons.length];
        for(int i = 0; i < persons.length; i++){
            int p = persons[i];
            max = Math.max(++people[p],max);
            leading[i] = people[p] == max ? p : leading[i-1];
        }
    }
    
    public int q(int t) {
        return leading[binarySearch ( times, t, 0, times.length -1)];
    }
    
     private int binarySearch(int[] times, int target, int left, int right) {
        if(left>right) {
            return right;
        }
        int mid = (left+right)/2;
        if(times[mid]>target) {
            return binarySearch(times, target, left, mid-1);
        } else if(times[mid]<target) {
            return binarySearch(times, target, mid+1, right);
        } else {
            return mid;
        }
    }
}
