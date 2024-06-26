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
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) {
            return null;
        }
        
        // Swap the children in the subtree.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // Recursively swap the children in each subtree.
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
        
    }
}