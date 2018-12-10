Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

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
    List<String> k = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return k;
        paths(root,"");
        return k;
    }
    private void paths(TreeNode root, String s){
        if(root == null)
            return;
        s= s + root.val + "->";
        if(root.left == null && root.right == null){
            s = s.substring(0,s.length()-2);
            k.add(s);
            s= "";
        }
        paths(root.left,s);
        paths(root.right,s);
    }
}
