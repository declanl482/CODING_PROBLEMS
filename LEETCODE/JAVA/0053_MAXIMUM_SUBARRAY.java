class Solution {
    public int maxSubArray(int[] nums) {
        // Implement Kadane's algorithm to compute subarray sums.
        // Time Complexity: O(n)
        
        int currentSum = 0;
        int maxSum = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = maxSum < currentSum ? currentSum : maxSum;
            currentSum = currentSum < 0 ? 0 : currentSum;
        }
        
        return maxSum;
    }
}