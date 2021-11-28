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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList();
        HashMap<Integer,Integer> set = new HashMap();
        boolean xf=false;
        boolean yf = false;
        q.add(root);
        while(!q.isEmpty()&&!xf&&!yf){
            int size = q.size();
            while(size-->0){
                TreeNode n = q.poll();             
                if(n.left!=null) {
                    q.add(n.left);
                    if(n.left.val==x||n.left.val==y){
                    if(n.left.val==x) xf=true;
                    if(n.left.val==y) yf=true;
                    set.put(n.left.val,n.val);}
                }
                if(n.right!=null){
                    q.add(n.right);
                  if(n.right.val==x||n.right.val==y){
                    if(n.right.val==x) xf=true;
                    if(n.right.val==y) yf=true;
                    set.put(n.right.val,n.val);}
                }
                } 
            }
        
        return xf&&yf&&(set.get(x)!=set.get(y));
    }
}
