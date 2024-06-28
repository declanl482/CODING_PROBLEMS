class Solution {
    public int climbStairs(int n) {
        // Base cases:
            // n = 1 : 1 way using 1 step
            // n = 2 : 2 ways using two 1 steps or one 2 step
        
        if (n <= 2) {
            return n;
        }
        
        // For each stair n, dynamically compute the number of ways to reach stair n, where # ways = dp[n - 1] + dp[n - 2].
        // This considers both the cases where we choose to use a 1 step from stair (n - 1) to n and when we choose to use a 2 step from stair (n - 2) to n.
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        // Return the dynamically computed result for the n-th stair.
        return dp[n - 1];
    }
}