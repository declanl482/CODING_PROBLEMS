class Solution {

    private void backtrack(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        // Add each subset to the result list on each recursive call.
        res.add(new ArrayList<>(subset));

        // Explore all other remaining elements in the solution space.
        for (int j = i; j < nums.length; j++) {

            // Skip duplicate elements (sorting the array in the calling function gave us this nice property of
            // adjacent duplicates).
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }

            // Explore the j-th element as part of the solution.
            subset.add(nums[j]);
            backtrack(nums, j + 1, subset, res);
            
            // Backtrack by removing the j-th element as part of the solution.
            subset.remove(subset.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the input array so that we are able to filter out duplicates.
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
}
