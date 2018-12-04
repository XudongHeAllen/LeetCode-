Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Note:

Both of the given trees will have between 1 and 100 nodes.
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return helper(root1, new StringBuilder()).toString().equals(helper(root2, new StringBuilder()).toString()) ? true : false;
    }
    private StringBuilder helper(TreeNode root, StringBuilder sb){
        if(root == null)
            return sb;
        if(root.left == null && root.right ==null){
            sb.append("" + root.val);
            return sb;
        }
        helper(root.left, sb);
        helper(root.right, sb);
        return sb;
    }
}
