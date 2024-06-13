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

    // Method for performing a BFS search on a binary tree.
    public void bfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();

                // Add the rightmost node at each level to the list of right-side visible nodes.
                if (i == n - 1) {
                    list.add(cur.val);
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        // At each level of the binary tree, add the rightmost node value to the result list.
        // We will find these rightmost nodes using the BFS algorithm.
        List<Integer> res = new ArrayList<>();
        bfs(root, res);
        return res;
    }
}