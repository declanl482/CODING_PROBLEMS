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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // In a BST, every subtree must maintain the condition that:
            // left.val <= root.val && right.val >= root.val

        // Return the root directly as the LCA if it is either p or q, exclusive, or it is null.
        if (root == null || root == p || root == q) { return root; }

        // Solve the problem for the remaining left and right subtrees recursively.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Return the LCA if it is found in one of the subtrees, otherwise return the root.
        return (left == null) ? right : ((right == null) ? left : root);

    }
}
