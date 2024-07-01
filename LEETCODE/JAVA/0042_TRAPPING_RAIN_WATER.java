class Solution {
    public int trap(int[] height) {

        // Maintain pointers at each end of the blocks.
        int left = 0;
        int right = height.length - 1;
        
        // Maintain records of the tallest block height we have seen coming both from the left, and from the right.
        int leftMax = height[left];
        int rightMax = height[right];
        
        // Maintain a record of all the water we have accumulated.
        int water = 0;
        
        // Squeeze the pointers together.
        while (left < right) {

            // The idea is that we will accumulate all water across all blocks until there are no more blocks to be processed.
            // We can choose to start with the left side if the leftMax is strictly less than the right, but this is arbitrary.
            // The general expression modeling the amount of water accumulated at any block index i is (max_i - i).
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            }
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        
        return water;
    }
}