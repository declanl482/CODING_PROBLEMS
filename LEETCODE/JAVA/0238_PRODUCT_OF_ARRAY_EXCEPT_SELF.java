class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        
        int prefix = 1;
        for (int i = 0; i < N; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        
        int suffix = 1;
        for (int i = N - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }
        
        return res;
    }
}