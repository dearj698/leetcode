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
    List<String> res = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }
    
    private void dfs(TreeNode node, String str){
        if(node.left==null&&node.right==null){
            
            res.add(str+node.val); 
        }
        if(node.left!=null){
           dfs(node.left, str+node.val+ "->");
        }
        if(node.right!=null){
            dfs(node.right,str+node.val+ "->");
        }
    }
}