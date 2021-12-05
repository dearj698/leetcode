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
    Deque<TreeNode> queue = new ArrayDeque();
    public void flatten(TreeNode root) {
        dfs(root);
        TreeNode cur = new TreeNode(-1);
        TreeNode res = cur;
        while(!queue.isEmpty()){
            cur = queue.poll();
            cur.left = null;
            cur.right = queue.peek();
        }
    }
    private void dfs(TreeNode root){
        if(root==null) return;
        queue.offer(root);
        dfs(root.left);
        dfs(root.right);
    }
    
}