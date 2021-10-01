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
    public  int max = 0;
    public int maxDepth(TreeNode root) {
        recursive(0,root);
        System.out.println(max);
        return max;
    }
    public void recursive(int depth, TreeNode root){
        System.out.println(depth);
        if(root == null){
            max = Math.max(depth,max);
             System.out.println(depth);
            return;
        }
        depth++;
        System.out.println(depth);
        recursive(depth, root.right);
        recursive(depth, root.left);
        System.out.println(depth);
        return;
    }
}