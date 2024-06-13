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
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validateBST(TreeNode root, long min, long max) {

        // Return true if the tree is initially empty or a path has been exhausted.
        if (root == null) {
            return true;
        }

        // Check that root.val is within the range: (min, max). Return false if root.val is not within range.
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Recursively validate the left and right subtrees.
        // For the left subtrees, update the range to be (min, root.val).
        // For the right subtrees, update the range to be (root.val, max).
        return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
    }
}
