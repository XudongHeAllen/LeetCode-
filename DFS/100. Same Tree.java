Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

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
    public boolean inOrderTraversal(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null && q != null)
            return false;
        else if(p != null & q == null)
            return false;
        
        boolean left = inOrderTraversal(p.left, q.left);
        boolean mid = (p.val == q.val);
        boolean right = inOrderTraversal(p.right, q.right);
        
        return left && right && mid;
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        return inOrderTraversal(p,q);
    }
    
}
