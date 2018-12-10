You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }
    private void helper(TreeNode root, List<Integer> result, int depth){
        if(root == null)
            return;
        if( depth == result.size())
            result.add(root.val);
        else{
            result.set(depth, Math.max(result.get(depth), root.val));
        }
        helper(root.left,result, depth + 1);
        helper(root.right,result, depth + 1);
    }
}
