Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

Observation 1: our highest prioirty is to move the number that is at index 0, with index 1 being 0
    For example, if we have 3004567 and we want to remove 1 digit, we defintely want to remove 3, so that we can
    get rid of the following 2 zeros, ending up with 4567, which will always give us the biggest decrease

Observation 2: if there is no case of observation 1, then we want to remove the biggest number in the first ascenging sequence.
    For example, if we have 234543, we want to remove the 5 first, since after 5 the number starts going down.
    
Observatino 3: if we have to remove more than 1 digit, every digit removal can use the same strategy, i.e we can use greedy algorithm here, aka not dp. 

class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k)
            return "0";
        List<Character> list = new ArrayList<>();
        for(char c: num.toCharArray()){
            list.add(c);
        }
        for(int i = 0; i < k; i++){
            int size = list.size();
            if(size > 1 && list.get(1) == '0'){
                list.remove(0);
                while(!list.isEmpty() && list.get(0) == '0'){
                    list.remove(0);
                }
            }
            if(size == list.size()){
                for(int j =0; j < size; j++){
                    if(j < size -1 && list.get(j) > list.get(j+1) || (j == size -1)){
                        list.remove(j);
                        break;
                    }
                }
            }
        }
        if(list.size() == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        for(Character c: list){
            result.append(c);
        }
        return result.toString();
    }
}
