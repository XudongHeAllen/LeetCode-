Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
          
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
    TreeNode res;
    public void flatten(TreeNode root) {
        if(root == null)
            return; 
        helper(root);
    }
    private TreeNode helper(TreeNode root){
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left == null && right == null)
            return root;
        if(left!= null){
            TreeNode leaf = helper(left);
            leaf.right = right;
            root.right = left;
            root.left = null;
            root = leaf;
        }
        return right != null ? helper(right): root;
    }
}
