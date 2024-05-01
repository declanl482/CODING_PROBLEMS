class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        // Ensure that the input argument for nums1 is larger than (or equal in size to) the
        // nums2 input.
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        // Compute the total and half number of elements among the two arrays.
        int total = n + m;
        int half = (total + 1) / 2;
        
        int left = 0;
        int right = n;
        
        var res = 0.0;
        
        // Perform a binary search until the appropriate partition point is determined.
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = half - i;
            
            // Compute the elements in each array which border the partition point.
            int left1 = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = (i < n) ? nums1[i] : Integer.MAX_VALUE;
            int left2 = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = (j < m) ? nums2[j] : Integer.MAX_VALUE;
            
            // Check if the partition point is correct.
            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 == 0) {
                    res = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                else {
                    res = Math.max(left1, left2);
                }
                break;
            }
            else if (left1 > right2) {
                // If the partition is too far right, move the right pointer back.
                right = i - 1;
            }
            else {
                // If the partition is too far left, move the left pointer forward.
                left = i + 1;
            }
        }
        
        return res;
    }
}