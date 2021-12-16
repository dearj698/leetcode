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
    int max;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        max = Integer.MIN_VALUE;
        maxsum(root);
        return max;
    }
    private int maxsum(TreeNode node){
        if(node==null) return 0;
        int left = Math.max(0, maxsum(node.left));
        int right = Math.max(0,maxsum(node.right));
        max = Math.max(left+right+node.val,max);
        return Math.max(left,right)+node.val;
    }
}