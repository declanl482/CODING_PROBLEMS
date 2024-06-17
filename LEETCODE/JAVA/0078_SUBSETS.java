class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, res, subset);
        return res;

    }

    private void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> subset) {
        // Stop backtracking when we have finished evaluating the solution space.
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // Make the choice to add the current element to the subset.
        // Recursively compute the subsets for the next element in the input array using the current solution space.
        subset.add(nums[i]);
        dfs(nums, i + 1, res, subset);
        
        // Make the choice not to add the current element to the subset.
        // Recursively compute the subsets for the next element in the input array using the current solution space.
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, res, subset);
    }
}
