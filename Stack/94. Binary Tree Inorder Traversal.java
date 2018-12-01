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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new LinkedList<Integer>();
        
        Stack<TreeNode> tree = new Stack<>();
        HashMap<TreeNode, Boolean> hm = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        tree.push(root);
        hm.put(root,true);
        while(!tree.isEmpty()){
            TreeNode curr = tree.peek();
            if(curr.left != null && !hm.containsKey(curr.left)){
                tree.push(curr.left);
                hm.put(curr.left, true);
            }else{
                result.add(curr.val);
                hm.put(curr,false);
                curr = tree.pop();
                if(curr.right != null){
                    tree.push(curr.right);
                    hm.put(curr.right, true);
                }
            }
        }
        return result;
    }
}
