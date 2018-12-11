In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.

Illustration of graph

graph will have length at most 10000.
The number of edges in the graph will not exceed 32000.
Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        int[] visited = new int[n];
        
        for(int i = 0; i < n; i++){
            if(helper(graph, i, visited))
                res.add(i);
        }
        return res;
    }
    private boolean helper(int[][] graph, int i, int[] visited){
        if(visited[i] == 1)
            return false;
        visited[i] = 1;
        for(int neighbor : graph[i]){
            int statu = visited[neighbor];
            if(statu == 1)
                return false;
            if(statu == 2)
                continue;
            if(!helper(graph, neighbor, visited))
                return false;
        }
        visited[i] = 2;
        return true;
    }
}
