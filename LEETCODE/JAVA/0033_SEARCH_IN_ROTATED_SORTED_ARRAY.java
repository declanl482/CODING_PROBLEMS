class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[left] <= nums[mid]) {
                // Check if the smallest element in the left subarray is less than or equal to
                // the target and the target is less than the middle element of the current array.
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else if (nums[right] >= nums[mid]) {
                // Check if the largest element in the right subarray is greater than or equal to
                // the target and the target is greater than the middle element of the current array.
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}