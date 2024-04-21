class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        
        // Compute the area of water in between the two walls, using the smaller wall as
        // the limiting factor in this computation. Recompute the maximum for each set of
        // walls and return the final value.
        while (left < right) {
            int water = (right - left) * Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, water);
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxWater;
    }
}