One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:

Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
Example 2:

Input: "1,#"
Output: false
Example 3:

Input: "9,#,#,1"
Output: false

class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack stack = new Stack();
        String[] arr = preorder.split(",");
        boolean ans = false;
        
        for(int i = 0;i < arr.length;i++){
            if(!arr[i].equals("#")){
                stack.push(arr[i]);
            }
            if(stack.isEmpty() && arr[i].equals("#") && i== arr.length-1)
            {
                stack.push("#");
            }
            if(stack.isEmpty() && arr[i].equals("#") && i != arr.length-1){
                ans = false;
                break;
            }
            if(!stack.isEmpty() && arr[i].equals("#") && i != arr.length -1)
                stack.pop();           
        }
        if(!stack.isEmpty() && stack.size() == 1){
            if(stack.peek().equals("#"))
                ans = true;
            else
                ans = false;
        }
        if(stack.isEmpty())
            ans = false;
        return ans;
    }
}

class Solution {
    private String s;
    private int current;
    private boolean res = true;
    
    private void consume() {
        if (current >= s.length()) {
            res = false;
            return;
        }
        
        if (s.charAt(current) == '#') {
            current += 2;
            return;
        }
        
        while (current < s.length() && s.charAt(current) >= '0' && s.charAt(current) <= '9')
            current++;
        current ++;
        consume();
        consume();
    }
    
    public boolean isValidSerialization(String preorder) {
        this.s = preorder;
        this.current = 0;
        consume();
        
        if (current >= s.length()) return res;
        else return false;    
    }
}
