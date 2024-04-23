class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Merge the two sorted arrays into a new sorted array.
        
        int N = nums1.length;
        int M = nums2.length;
        
        int mergeLen = N + M;
        int[] merge = new int[mergeLen];
        
        int nums1Ptr = 0;
        int nums2Ptr = 0;
        int mergePtr = 0;
        
        while (nums1Ptr < N && nums2Ptr < M) {
            if (nums1[nums1Ptr] < nums2[nums2Ptr]) {
                merge[mergePtr++] = nums1[nums1Ptr++];
            }
            else {
                merge[mergePtr++] = nums2[nums2Ptr++];
            }
        }
        
        while (nums1Ptr < N) {
            merge[mergePtr++] = nums1[nums1Ptr++];
        }

        while (nums2Ptr < M) {
            merge[mergePtr++] = nums2[nums2Ptr++];
        }
        
        // If N (the size of the merged array) is odd, the median is M[N / 2].
        // If N is even, the median is (M[N / 2] + M[(N / 2) + 1]) / 2.
        
        if (mergeLen % 2 == 0) {
            return (double)(merge[mergeLen / 2] + merge[(mergeLen / 2) - 1]) / 2;
        }
        else {
            return (double)merge[mergeLen / 2];   
        }
    }
}