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

    private void bfs(TreeNode root, List<List<Integer>> list) {
        // If the root node is null, there are no nodes to BFS on, return.
        if (root == null) {
            return;
        }

        // Implement a queue using a linked list, where we enqueue at the tail and dequeue at the head.
        // Initially, the queue will contain the non-null root node.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Create a intermediate list for storing the elements of the current level from left to right.
            List<Integer> temp = new ArrayList<>();

            // Dequeue nodes (leftmost first) and their values from the queue and into the intermediate list, respectively.
            // Additionally, enqueue the nodes of the dequeued children (leftmost first).
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();

                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }

                temp.add(cur.val);
            }

            // Add the list of values for the nodes at the current level from left to right to the result list.
            list.add(temp);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        bfs(root, res);
        
        return res;

    }
}
