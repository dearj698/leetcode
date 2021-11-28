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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return hps(root, targetSum);
    }
    private boolean hps(TreeNode node, int sum){
        if(node.left==null&&node.right==null&&node.val == sum) return true;
        
        boolean l= false;
        boolean r = false;
        if(node.left!=null){
            l = hps(node.left, sum-node.val);
        }
        if(node.right!=null){
            r = hps(node.right, sum-node.val);
        }
        return l||r;
    }
}