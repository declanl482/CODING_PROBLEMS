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
    
    private int dfs(TreeNode root, int maxVal) {
        // Return 0 if the tree was initially empty or a path has been exhausted.
        if (root == null) {
            return 0;
        }

        // If the value of the root node is less than its maximum, we do not have a good node.
        // Otherwise, the root node is good because it has a value at least as large as its maximum.
        int res = (root.val < maxVal) ? 0 : 1;

        // Update the maximum value in the DFS search path for the next recursive call.
        maxVal = Math.max(maxVal, root.val);

        // Accumulate the count of good nodes by recursively calling the dfs function
        // on the left and right subtrees.
        res += dfs(root.left, maxVal);
        res += dfs(root.right, maxVal);

        // Return the total count of good nodes.
        return res;
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}
