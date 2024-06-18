class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(nums, target, 0, res, combination);
        return res;
    }

    private void backtrack(int[] nums, int target, int i, List<List<Integer>> res, List<Integer> combination) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            combination.add(nums[j]);
            backtrack(nums, target - nums[j], j, res, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
