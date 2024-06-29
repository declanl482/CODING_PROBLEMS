class Solution {
    public int maxSubArray(int[] nums) {

        // Implementing an algorithm known as Kadane's algorithm.

        // Initialize the maximum subarray sum as the value of the first element in the input array.
        int max = nums[0];
        int sum = 0;

        // Track the running subarray sum over the entire array.
        for (int num : nums) {
            // Compute the sum of the current subarray and maximize the result.
            sum += num;
            max = Math.max(max, sum);

            // If the sum of the current subarray becomes negative, reset the subarray by resetting the sum to 0.
            // This is a greedy method of maximizing the subarray sum. For negative values, they will be maximized by
            // the Math.max call above if the maximum subarray sum happens to be negative.
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
