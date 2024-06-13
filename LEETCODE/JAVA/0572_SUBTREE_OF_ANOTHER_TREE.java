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

    // Method which compares two binary trees on structural and numerical (node values) equality.
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        return (p != null && q != null && p.val == q.val) ? isSameTree(p.left, q.left) && isSameTree(p.right, q.right) : false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // A null subRoot implies that the subRoot tree is empty. An empty tree is a subset of all trees.
        if (subRoot == null) {
            return true;
        }

        // At this point the subRoot is non-null, which implies that the subRoot tree is not empty. Thus if the
        // root is null, implying that the root tree is empty, it is not possible for the subRoot tree to be a 
        // subtree of the root tree.
        if (root == null) {
            return false;
        }

        // If there is an instance of the subRoot being a subtree of the root tree, return true.
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Check the left and right subtrees for instances of the subRoot.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }
}
