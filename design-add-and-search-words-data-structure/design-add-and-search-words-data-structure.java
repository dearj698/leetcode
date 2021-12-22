class WordDictionary {
    class TrieNode{
        boolean isEnd = false;
        HashMap<Character, TrieNode> map;
        public TrieNode(){
            map = new HashMap();
        }
    }
        TrieNode head;
    /** Initialize your data structure here. */
    public WordDictionary() {
        head = new TrieNode();
    }
    
    public void addWord(String word) {
        if(word==null) return;
        TrieNode node = head;
        int counter = 0;
        for(char ch: word.toCharArray()){
            if(!node.map.containsKey(ch)){
                node.map.put(ch,new TrieNode());
            }
            node = node.map.get(ch);
        }
        node.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode node = head;
        return search(word, 0, node);
    }
    
    private boolean search(String word, int idx, TrieNode node) {
        if (idx == word.length()) {
            return node.isEnd;
        }
        if (word.charAt(idx) == '.') {
            for (char c : node.map.keySet()) {
                if (search(word, idx + 1, node.map.get(c))) {
                    return true;
                }
            }
        }
        else {
            if (node.map.get(word.charAt(idx)) != null) {
                return search(word, idx + 1, node.map.get(word.charAt(idx)));
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */