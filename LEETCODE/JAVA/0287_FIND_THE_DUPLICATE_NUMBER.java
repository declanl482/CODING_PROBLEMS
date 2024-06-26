class Solution {
    public int findDuplicate(int[] nums) {
        // Use the tortoise vs. hare algorithm to find the duplicate.

        // Detect the cycle using a slow and fast pointer.
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Reset the tortoise. Find the entry point into the cycle.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
