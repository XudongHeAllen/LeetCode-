Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].


class Solution {
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] groups = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            groups[i] = i;
        }
        for (int[] dislike : dislikes) {
            int p1 = dislike[0], p2 = dislike[1];
            if (groups[p2] == p2) {
                groups[p2] = p1;
                continue;
            }
            int[] uf1 = unionFind(p1, groups), uf2 = unionFind(p2, groups);
            if (uf1[0] == uf2[0] && uf1[1] == uf2[1]) {
                return false;
            }
        }
        return true;
    }
    
    private int[] unionFind(int p, int[] groups) {
        int group = -1;
        while (groups[p] != p) {
            p = groups[p];
            group *= -1;
        }
        return new int[]{ p, group };
    }
    
    // BFS Solution O(V + E)
    // public boolean possibleBipartition(int N, int[][] dislikesArr) {
    //     final Map<Integer, Set<Integer>> dislikesMap = new HashMap<>();
    //     for (int i = 1; i <= N; i++) {
    //         dislikesMap.put(i, new HashSet<Integer>());
    //     }
    //     for (int[] dislike : dislikesArr) {
    //         int p1 = dislike[0], p2 = dislike[1];
    //         dislikesMap.get(p1).add(p2);
    //         dislikesMap.get(p2).add(p1);
    //     }
    //     final int[] groups = new int[N + 1];
    //     final Queue<Integer> q = new LinkedList<>();
    //     for (int p = 1; p <= N; p++) {
    //         if (groups[p] != 0 || !dislikesMap.containsKey(p)) {
    //             continue;
    //         }
    //         q.offer(p);
    //         groups[p] = -1;
    //         while (!q.isEmpty()) {
    //             int person = q.poll(), group = groups[person] * -1;
    //             Set<Integer> dislikes = dislikesMap.get(person);
    //             for (int dislike : dislikes) {
    //                 if (groups[dislike] == 0) {
    //                     groups[dislike] = group;
    //                     q.offer(dislike);
    //                 } else if (groups[dislike] == group) {
    //                     continue;
    //                 } else {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }
}
