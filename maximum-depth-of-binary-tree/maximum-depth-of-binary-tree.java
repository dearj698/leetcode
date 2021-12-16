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
    int depth = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        maxd(root, 1);
        return depth;
    }
    
    private void maxd(TreeNode node, int curd) {
        if(node.left == null && node.right ==null){
            this.depth = Math.max(curd, this.depth);
        }

        if(node.left!= null) {
            maxd(node.left, curd+1);
        }
        
        if(node.right!= null) {
            maxd(node.right, curd+1);
        }
    }
}