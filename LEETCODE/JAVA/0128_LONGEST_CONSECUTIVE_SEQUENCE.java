class Solution {
    public int longestConsecutive(int[] nums) {
        
        // Add each array element to a hashset.
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int maxLen = 0;
        for (int num : numSet) {
            int len = 0;
            
            // Check if the current number is the start of a sequence.
            if (!numSet.contains(num - 1)) {
                while (numSet.contains(num + len)) {
                    len++;
                }
            }
            
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}