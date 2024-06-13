class Solution {
    
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if (left == -1 || right == -1) {
            return -1;
        }
        
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        
        return Math.max(left, right) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (dfs(root) == -1) {
            return false;
        }
        
        return true;
    }
}