Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<StringBuilder> stringStack = new Stack<>();
        stringStack.push(new StringBuilder());
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num*10 + (c- '0');
            else if(c =='['){
                intStack.push(num);
                sb = new StringBuilder();
                stringStack.push(sb);
                num = 0;
            }else if(c ==']'){
                int repeat = intStack.pop();
                sb = stringStack.pop();
                String str = sb.toString();
                for(int j = 0; j < repeat-1;j++){
                    sb.append(str);
                }
                stringStack.peek().append(sb.toString());
            }else{
                stringStack.peek().append(c);
            }
        }
        return stringStack.peek().toString();
    }
}
