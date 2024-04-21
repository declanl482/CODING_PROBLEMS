class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hset = new HashSet<Integer>();

        // Add each element of the array to the hashset until a duplicate is encountered.        
        for (int i = 0; i < nums.length; i++) {
            if (!hset.add(nums[i])) {
                return true; 
            }
        }

        return false;
    }
}