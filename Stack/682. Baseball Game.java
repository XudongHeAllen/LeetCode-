You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.

class Solution {
    public int calPoints(String[] ops) {
        Stack stack = new Stack<>();
        int sum = 0;
        for(String s:ops){
            if(s.charAt(0) == 'D'){
                int p = (int)stack.peek();
                stack.push(2*p);
                sum += 2*p;
            }
            else if(s.charAt(0) == 'C'){
                int x = (int)stack.pop();
                sum -= x;
            }
            else if(s.charAt(0) =='+'){
                int a = (int)stack.pop();
                int p = (int)stack.peek();
                sum += a+p;
                stack.push(a);
                stack.push(a+p);
            }else{
                int x = Integer.parseInt(s);
                stack.push(x);
                sum += x;
            }
        }
        return sum;
    }
}
