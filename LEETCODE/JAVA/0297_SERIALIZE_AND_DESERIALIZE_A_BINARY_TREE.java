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

 public class Codec {

    private void dfsSerialize(TreeNode root, List<String> list) {

        // If we run into a null node, add "N" to the string to represent this null node.
        if (root == null) {
            list.add("N");
            return;
        }

        // If we run into a non-null node, add the string representation of the node's value.
        list.add(Integer.toString(root.val));

        // Recursively add nodes into the list.
        dfsSerialize(root.left, list);
        dfsSerialize(root.right, list);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Get the values of all nodes as strings in a list.
        List<String> list = new ArrayList<>();

        // Recursively add node values to the list.
        dfsSerialize(root, list);

        // Join each string by a delimeter and return the joined string.
        return String.join(",", list);
    }

    private TreeNode dfsDeserialize(String[] strs, int[] i) {
        // If we encounter a null node, return null and increment the position counter.
        if (strs[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        // If we encounter a non-null node, construct the node using its value, and increment the position counter.
        TreeNode root = new TreeNode(Integer.valueOf(strs[i[0]]));
        i[0]++;

        // Recursively build the left and right subtrees.
        root.left = dfsDeserialize(strs, i);
        root.right = dfsDeserialize(strs, i);

        // Return the root at each recursive call.
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Split the serialized string using the delimeter.
        String[] strs = data.split(",");

        // Pass the position counter as an array of size 1, so that the value of i[0] is updated
        // across recursive calls (java passes object references by value).
        int[] i = {0};

        return dfsDeserialize(strs, i);
    }
}
