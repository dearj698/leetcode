/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {//1,2,n,n,3,4,n,n,5,n,n,
        if(root==null) return "n,";
        String left = serialize(root.left);//2,n,n,
        String right = serialize(root.right);//3,4,n,n,5,n,n,
        return root.val + ","+left+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new ArrayDeque();
        queue.addAll(Arrays.asList(data.split(",")));
        return des(queue);
    }
    
    private TreeNode des(Deque<String> queue){
        String letter = queue.poll();
        if(letter.equals("n")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(letter));
        root.left = des(queue);
        root.right = des(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));