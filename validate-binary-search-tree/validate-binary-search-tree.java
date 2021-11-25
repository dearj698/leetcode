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
    public boolean isValidBST(TreeNode root) {
        if(root.left==null&&root.right==null) return true;
        return validTree(root,Long.MAX_VALUE, Long.MIN_VALUE);
    }
    private boolean validTree(TreeNode root, long max, long min){
        if(root==null) return true;
        if(root.val>=max||root.val<=min) return false;
        return validTree(root.left,root.val, min)&&validTree(root.right,max,root.val);
    }
}