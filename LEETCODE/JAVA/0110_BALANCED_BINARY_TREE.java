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
    
    // Recursive depth-first-search function which simultaneously checks if current subtree is balanced
    // based on the maximum depths of the left and right subtrees, at the time of the recursive call.
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        // If the subtree was determined to not be balanced at some prior recursive call, left or right will be
        // assigned a value of -1, indicating that the subtree is not balanced.
        if (left == -1 || right == -1) {
            return -1;
        }

        // Return -1 when the current subtree is not balanced.
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        
        return Math.max(left, right) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {        
        // Perform a recursive DFS of the entire binary tree, exhuasting all subtrees until they have
        // been confirmed to be balanced. If at any point there is a subtree which is not balanced, the
        // recursive calls will ultimately return -1, indicating that we should return false.
        return dfs(root) != -1;
    }
}