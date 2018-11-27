Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

class WordDictionary {
    
    Map<Integer, List<String>> map;

    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int l = word.length();
        if(!map.containsKey(l))
            map.put(l, new ArrayList<String>());
        map.get(l).add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int l = word.length();
        if(map.containsKey(l)){
            List<String> words = map.get(l);
            for(String w : words)
                if (compare(w,word))
                    return true;
        }
        return false;    
    }
    
    private boolean compare(String s1, String s2){
        int p=0;
        while(p<s1.length()){
            if(s2.charAt(p) != '.' && s1.charAt(p) != s2.charAt(p))
                return false;
            p++;
        }
    return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
