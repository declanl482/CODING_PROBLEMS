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

    private int res = 0;

    private int dfs(TreeNode root) {

        // Stop searching if the current subtree is empty.
        if (root == null) {
            return 0;
        }

        // Recursively compute the depths of the left and right subtrees.
        // Discard negative path sums, as we are trying to maximize the path sum;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        // Maximize the path sum at each recursive call.
        res = Math.max(res, root.val + left + right);

        // Maximize the path sum returned by each recursive call between the left and right child.
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        // Initialize the result variable to be the value of the original root node by default.
        res = root.val;
        dfs(root);
        return res;
    }
}
