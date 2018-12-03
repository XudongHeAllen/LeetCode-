Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        Stack <TreeNode> s = new Stack<>();
        s.push(root);
        int level = 0;
        while(!s.isEmpty()){
            level++;
            Stack<TreeNode> temp = new Stack<>();
            List<Integer> list = new ArrayList<>();
            while(!s.isEmpty()){
                TreeNode n = s.pop();
                if(n != null){
                    list.add(n.val);
                    if(level %2 != 0){
                        temp.push(n.left);
                        temp.push(n.right);
                    }else{
                        temp.push(n.right);
                        temp.push(n.left);
                    }
                }
            }
            if(list.size() != 0)
                result.add(list);
            s = temp;

            
        }
        return result;
    }
}

Recurise way:
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null) return ret;
        travel(root,ret,0);
        return ret;
    }
    
    private void travel(TreeNode root, List<List<Integer>> ret, int level){
        if(root==null) return;
        
        if(ret.size()==level){
            List<Integer> temp = new ArrayList<Integer>();
            ret.add(temp);
        }
        
        List<Integer> list = ret.get(level);
        if(level%2==0) list.add(root.val);
        else list.add(0,root.val);
        
        travel(root.left,ret,level+1);
        travel(root.right,ret,level+1);
    }
}
