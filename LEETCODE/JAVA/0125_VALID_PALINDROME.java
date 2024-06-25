class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left <= right) {
            // Remove non-alphanumeric characters at the left side.
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                // Remove non-alphanumeric characters at the right side.
                right--;
            }
            else {
                // Check that alphanumeric characters at each end are equal (case-insensitive).
                if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}