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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If we have exhuasted the nodes of each of the subtrees for each of the trees, then we can return true, as
        // this entails that the subtrees are identical across the recursive calls.
        if (p == null && q == null) {
            return true;
        }

        // If we have two non-null nodes in the same relative position with the same value, then we will check that the
        // left and right subtrees are also the same. Otherwise, we can return false directly from a counterexample.
        return (p != null && q != null && p.val == q.val) ? isSameTree(p.left, q.left) && isSameTree(p.right, q.right) : false;
    }
}
