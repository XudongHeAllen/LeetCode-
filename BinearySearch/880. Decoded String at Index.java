An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:

If the character read is a letter, that letter is written onto the tape.
If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.

 

Example 1:

Input: S = "leet2code3", K = 10
Output: "o"
Explanation: 
The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".
Example 2:

Input: S = "ha22", K = 5
Output: "h"
Explanation: 
The decoded string is "hahahaha".  The 5th letter is "h".
Example 3:

Input: S = "a2345678999999999999999", K = 1
Output: "a"
Explanation: 
The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 

Note:

2 <= S.length <= 100
S will only contain lowercase letters and digits 2 through 9.
S starts with a letter.
1 <= K <= 10^9
The decoded string is guaranteed to have less than 2^63 letters.

class Solution {
    /*If we have a decoded string like appleappleappleappleappleapple("apple6") and an index like K = 24, the answer is the same if K = 4.
In general, when a decoded string is equal to some word with size length repeated some number of times (such as apple with size = 5 repeated 6 times), the answer is the same for the index K as it is for the index K % size.
    */
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        for(char c : S.toCharArray()){
            if(c - '0'>= 0 && c - '0' <=9){
                size *= (c - '0');
            }else{
                size++;
            }
        }
       String res = "";
        int N = S.length();
        for(int i = N - 1; i >= 0 ; i--){
            char c = S.charAt(i);
            K %= size;//Exception in thread "main" java.lang.ArithmeticException: / by zero
            if(K == 0 && Character.isLetter(c)){
                
                return  Character.toString(c);
            }
            
            if(c - '0'>= 0 && c - '0' <=9){
                size /= (c - '0');
            }else{
                size--;
            }
        }
        return res;
    }
}
