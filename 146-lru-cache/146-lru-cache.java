class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
    }
    
    HashMap<Integer, DLinkedNode> cache = new HashMap<Integer,DLinkedNode>();
    DLinkedNode head, tail;
    int capacity;
    int count;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        
        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.next= null;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node!=null){
            node.value = value;
            this.moveToHead(node);
        }
        else{
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            cache.put(key, newNode);
            this.addNode(newNode);
            count++;
            if(count>capacity){
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
            
        }
    }
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }
    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        
        
        head.next.pre = node;
        head.next = node;
    }
    
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */