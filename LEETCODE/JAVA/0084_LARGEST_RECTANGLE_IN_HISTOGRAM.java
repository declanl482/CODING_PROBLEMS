class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // For each bar, compute the left and right limits that the bar can extend to.
        // After computing the left and right limits for each bar, compute the area associated with
        // each bar.
        // Return the maximum computed area.
        
        int n = heights.length;
        int[] leftLimits = new int[n];
        int[] rightLimits = new int[n];
        
        Stack<Integer> stack = new Stack<>();

        // Compute the left limits:
        
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= height) {
                stack.pop();
            }
            leftLimits[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        
        // Clear the stack:
        
        stack.clear();
        
        // Compute the right limits:
        
        for (int i = n - 1; i >= 0; i--) {
            int height = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= height) {
                stack.pop();
            }
            rightLimits[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }
        
        // Compute the maximum areas:
        
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = (rightLimits[i] - leftLimits[i] + 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}