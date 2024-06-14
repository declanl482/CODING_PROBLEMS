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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Return null when the nodes in the preorder or inorder array have been built and exhausted.
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // The first node in a preorder traversal is always the root of the tree.
        TreeNode root = new TreeNode(preorder[0]);

        // For the current subtree, find the middle node which divides its left and right subtrees.
        int mid = -1;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                mid = i;
                break;
            }
        }

        // Split the preorder array into two new arrays, one describing the left subtree and the other describing the right subtree.
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);

        // Recursively build the left subtree.
        root.left = buildTree(leftPreorder, leftInorder);

        // Split the inorder array into two new arrays, one describing the left subtree and the other describing the right subtree.
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);

        // Recursively build the right subtree.
        root.right = buildTree(rightPreorder, rightInorder);

        // Return the root of the built subtree.
        return root;

    }
}
