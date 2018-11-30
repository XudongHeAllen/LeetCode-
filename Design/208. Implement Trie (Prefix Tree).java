Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

class Trie {
    char val;
    Trie[] children;
    Set<String> set;
    /** Initialize your data structure here. */
    public Trie() {       
        val = '#';
        set = new HashSet<String>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] arr = word.toCharArray();
        if(children == null)
            children = new Trie[26];
        
        Trie itr = this;
        for(int i = 0; i < arr.length;i++){
            Trie child = itr.children[arr[i] - 'a'];
            if(child == null){
                child = new Trie();
                child.val = arr[i];
                child.children = new Trie[26];
                itr.children[arr[i] - 'a'] = child;
            }
            itr = child;
        }
        itr.set.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char arr[] = word.toCharArray();
        
        if(this.children == null)
            return false;
        Trie itr = this;
        
        for(int i = 0; i < arr.length;i++){
            Trie child = itr.children[arr[i] - 'a'];
            if(child == null)
                return false;
            itr = child;
        }
        if(itr.set.contains(word))
            return true;
        else
            return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char arr[] = prefix.toCharArray();
        
        if(this.children == null)
            return false;
        Trie itr = this;
        
        for(int i = 0; i < arr.length; i ++){
            Trie child = itr.children[arr[i] - 'a'];
            if(child == null)
                return false;
            itr = child;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
