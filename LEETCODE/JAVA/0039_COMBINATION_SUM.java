class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(nums, target, 0, res, combination);
        return res;
    }

    private void backtrack(int[] nums, int target, int i, List<List<Integer>> res, List<Integer> combination) {
        // If the current combination sum exceeds the target, stop exploring this branch.
        if (target < 0) {
            return;
        }

        // If the current combination sum equals the target, add the combination to the result list and stop exploring this branch.        
        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        // If the current combination sum is less than the target, recursively explore the other branches of the combination sum while backtracking.
        for (int j = i; j < nums.length; j++) {
            combination.add(nums[j]);
            backtrack(nums, target - nums[j], j, res, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
