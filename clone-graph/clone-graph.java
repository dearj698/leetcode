/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> cpy = new HashMap<>();
    Deque<Node> queue = new ArrayDeque();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node newRoot = new Node(node.val, new ArrayList<>());
        cpy.put(node, newRoot);
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            Node curcpy = cpy.get(cur);
            for (Node neighbor : cur.neighbors) {
                if(!cpy.containsKey(neighbor)){
                    cpy.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.push(neighbor);
            }
                    curcpy.neighbors.add(cpy.get(neighbor));
            }
        }
        return newRoot;
    }
}