Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.

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
    int maxLevel = 0;
    int bottomLeft = 0;
    public int findBottomLeftValue(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int level){
    if(root == null)
        return bottomLeft;
        
    maxLevel = Math.max(level, maxLevel);
    if(level == maxLevel)
        bottomLeft = root.val;
        
    helper(root.right, level + 1);
    helper(root.left, level + 1);
    return bottomLeft;
    }
}
