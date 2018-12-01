Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        
        for(char c: S.toCharArray()){
            if((c != '#')){
                s1.push(c);
            }
            else if(!s1.empty())
                s1.pop();
        }
        for(char c : T.toCharArray()){
            if((c != '#'))
                s2.push(c);
            else if(!s2.empty())
                s2.pop();
        }
        
        String str1 = String.valueOf(s1);
        String str2 = String.valueOf(s2);
        boolean test = true;
        if(str1.equals(str2))
        return true;
        else
            return false;
    }
}
