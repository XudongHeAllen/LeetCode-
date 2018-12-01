Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i <s.length(); i++){
            char b = s.charAt(i);
            if(b == '(' || b == '[' || b =='{')
                stack.push(b);
            else{
                char opening = '-';
                switch(b){
                    case ')' : opening = '(';
                        break;
                    case ']' : opening = '[';
                        break;
                    case '}' : opening = '{';
                        break;
                    default : opening = '-';
                }
                
                if(stack.empty() || stack.pop() != opening){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
