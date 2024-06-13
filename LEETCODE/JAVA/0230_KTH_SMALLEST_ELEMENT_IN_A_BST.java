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

/* Method 1: Using a stack to choose the k-th smallest node from. */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (root != null || !stack.isEmpty()) {

            // Fill the stack with nodes from the leftmost path in the current subtree.
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // Pop from the stack until the k-th smallest node is found.
            cur = stack.pop();
            if (--k == 0) {
                return cur.val;
            }

            // Move into the right subtree so that we can again extract all the nodes from the
            // leftmost path in the new subtree.
            cur = cur.right;
        }
        return -1;
    }
}

/* Method 2: Perform an inorder traversal of the BST. Return the k-th node's value. */

// class Solution {

//     // We want to maintain a counter of the i-th node being visited in the inorder traversal.
//     // We want to record the value of the k-th smallest node when counter == k.
//     private int counter = 0;
//     private int res = -1;

//     private void inorder(TreeNode root, int k) {
//         if (root == null) {
//             return;
//         }
        
//         // Traverse the left subtree.
//         inorder(root.left, k);

//         // Visit the current node to potentially save it as the k-th smallest node.
//         counter++;
//         if (counter == k) {
//             res = root.val;
//             return;
//         }

//         // Traverse the right subtree.
//         inorder(root.right, k);
//     } 

//     public int kthSmallest(TreeNode root, int k) {
//         if (root == null) {
//             return 0;
//         }
//         inorder(root, k);
//         return res;

//     }
// }