class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        
        // Sort the numbers in the input array in non-decreasing order.
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Check if we are evaluating a duplicate element on the next iteration.
            // This is to avoid creating duplicate triplets if there are any.
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Find triplets and add them to the result list.
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                }
                else if (sum > 0) {
                    right--;
                }
                else if (sum == 0) {
                    triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    // Skip duplicates on both the left and right ends to avoid creating
                    // triple duplicates.
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
                                   
        return triplets;
    }
}