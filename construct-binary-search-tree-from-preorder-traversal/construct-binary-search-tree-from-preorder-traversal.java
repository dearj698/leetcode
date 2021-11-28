/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode bst(int[] nodes, int max){
        int val = nodes[index];
        TreeNode root = new TreeNode(val);
        index++;
        if(index< nodes.length&&nodes[index]<root.val){
            root.left=bst(nodes, root.val);
        }
        if(index< nodes.length&&nodes[index]<=max){
            root.right = bst(nodes,max);
        }
        return root;
    }
}