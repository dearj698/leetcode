class Trie {
    class TrieNode{
        boolean isEnd = false;
        HashMap<Character, TrieNode> map;
        public TrieNode(){
            map = new HashMap();
        }
    }
    TrieNode head;
    
    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null) return;
        TrieNode node = head;
        for(char letter:word.toCharArray()){
            if(!node.map.containsKey(letter)){
                node.map.put(letter, new TrieNode());
            }
            node = node.map.get(letter);
        }
        node.isEnd=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word==null) return false;
        TrieNode node = head;
        for(char letter:word.toCharArray()){
            if(!node.map.containsKey(letter)) return false;
            node = node.map.get(letter);
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
                if(prefix==null) return false;
        TrieNode node = head;
        for(char letter:prefix.toCharArray()){
            if(!node.map.containsKey(letter)) return false;
            node = node.map.get(letter);
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